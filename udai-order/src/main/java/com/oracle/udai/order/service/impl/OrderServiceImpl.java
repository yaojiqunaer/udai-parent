package com.oracle.udai.order.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.order.domain.dto.OrderDetail;
import com.oracle.udai.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description:
 * @Author zhangxiaodong
 * @Date 2020/5/3 13:45
 * @Version V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * @param json json数据
     *             {
     *             "skuArray":[
     *             {
     *             "skuId":1,
     *             "skuCount":2
     *             },
     *             {
     *             "skuId":2,
     *             "skuCount":1
     *             }
     *             ],
     *             "voucherId":null
     *             }
     * @return
     * @description 创建订单
     * 1.先检查优惠券是否有效
     * 2.查询库存数量  >200先支付在减库存  <200先减库存在支付
     */
    @Override
    public JsonBean createOrder(JSONObject json) {
        boolean flag = true;
        Map<String, Object> map = this.getOrderDetailByJson(json);
        Integer voucherId = (Integer) map.get("voucherId");//优惠券ID
        List<OrderDetail> orderDetails = (List<OrderDetail>) map.get("orderDetails");//订单集合

        for (OrderDetail orderDetail : orderDetails) {
            //redis中的库存
            Integer count = (Integer) redisTemplate.opsForHash().get("product_" + orderDetail.getSkuId(), "count");
               /* 库存是否小于安全库存
                大于200先支付后减库存
                小于200先减库存在支付*/
            if (count < 200) {
                //任意一件商品的库存小于200
                //则跳出循环 进行
                flag = false;
                break;
            }
            /**
             *
             * 商品库存充足 ，直接生成订单
             *
             */


        }
        //某商品count<200
        if (!flag) {
            /*
             * 减库存，相关信息set，放入MQ中
             *
             */

        }




        return null;
    }

    /**
     * @param json
     * @return
     * @description 将json中数组取出封装
     */
    private Map<String, Object> getOrderDetailByJson(JSONObject json) {
        Integer voucherId = null;//优惠券ID
        if (json.get("voucherId") != null) {
            voucherId = (Integer) json.get("voucherId");
        }
        List<OrderDetail> orderDetails = new ArrayList<>();//订单详情
        //订单商品详情
        JSONArray skuArray = json.getJSONArray("skuArray");
        for (int i = 0; i < skuArray.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setSkuId(Integer.parseInt(skuArray.getJSONObject(i).get("skuId").toString()));
            orderDetail.setNum(Integer.parseInt(skuArray.getJSONObject(i).get("skuCount").toString()));
            orderDetails.add(orderDetail);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("voucherId", voucherId);
        map.put("orderDetails", orderDetails);
        return map;
    }
}
