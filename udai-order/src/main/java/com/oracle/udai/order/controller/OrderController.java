package com.oracle.udai.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.order.api.client.product.ProductClientAPI;
import com.oracle.udai.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description:
 * @Author zhangxiaodong
 * @Date 2020/4/29 21:07
 * @Version V1.0
 */
@RestController
@RequestMapping("order")
//全局默认服务降级
/*@DefaultProperties(defaultFallback = "defaultFallback",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),  //服务延时检测
        }
)*/
public class OrderController {


    @Autowired
    private ProductClientAPI productClientAPI;

    @Autowired
    private OrderService orderService;


    /**
     * @param id
     * @return
     * @description 服务降级：异常抛出，服务超时、关闭均会执行此方法
     */
    public JsonBean fallback(Integer id) {
        return new JsonBean(-999, "活动太火爆了，请稍后再试", null);
    }

    /**
     * @param
     * @return
     * @description 统一降级
     */
    public JsonBean defaultFallback() {
        return new JsonBean(-9999, "统一服务降级格式", null);
    }


    //@HystrixCommand(fallbackMethod = "fallback")  //自定义服务降级
   /* @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            //10s 10次 60%失败就熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//开启断路器模式（熔断操作）
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//断路器开启对主逻辑的熔断 10秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//60%打开断路器，默认50%
    })*/
    @RequestMapping("getProductInfo")
    public JsonBean getProductInfo(Integer id) {
        return productClientAPI.getProductById(id);//调用API 服务降级处理
    }


    /**
     * @param json 订单需要的json数据
     * @return
     * @description 创建生成订单
     */
    @PostMapping("createOrder")
    public JsonBean createOrder(@RequestBody JSONObject json) {
        System.out.println(json);
        System.out.println(json.get("voucherId"));
        return orderService.createOrder(json);
    }


}
