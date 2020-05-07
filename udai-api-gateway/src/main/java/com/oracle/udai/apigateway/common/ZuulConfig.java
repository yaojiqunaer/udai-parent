package com.oracle.udai.apigateway.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @ClassName ZuulConfig
 * @Description: 路由配置（未注入）
 * @Author zhangxiaodong
 * @Date 2020/5/1 14:56
 * @Version V1.0
 */
//@Component
public class ZuulConfig {


    @ConfigurationProperties("zull")
    @RefreshScope
    public ZuulConfig zuulConfig() {
        return new ZuulConfig();
    }

}
