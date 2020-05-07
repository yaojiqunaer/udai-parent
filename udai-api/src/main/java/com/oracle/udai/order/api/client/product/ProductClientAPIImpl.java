package com.oracle.udai.order.api.client.product;

import com.oracle.udai.common.JsonBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProductClientAPIImpl
 * @Description: 商品服务远程调用的降级处理
 * @Author zhangxiaodong
 * @Date 2020/5/6 19:20
 * @Version V1.0
 */
@Component
public class ProductClientAPIImpl implements ProductClientAPI {


    @Override
    public JsonBean getProductById(Integer id) {
        return new JsonBean(-111, "feign远程调用失败的降级处理", null);
    }
}
