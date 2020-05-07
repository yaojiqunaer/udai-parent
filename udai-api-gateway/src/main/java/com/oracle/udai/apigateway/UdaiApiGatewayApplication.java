package com.oracle.udai.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class UdaiApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdaiApiGatewayApplication.class, args);
    }

}
