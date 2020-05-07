package com.oracle.udai.order.api.client.product;

import com.oracle.udai.common.JsonBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用PRODUCT的服务 与hystrix结合
 * fallback为降级处理
 */
@FeignClient(name = "PRODUCT", fallback = ProductClientAPIImpl.class)
public interface ProductClientAPI {

    @RequestMapping("product/getProductById")
    public JsonBean getProductById(@RequestBody Integer id);
}
