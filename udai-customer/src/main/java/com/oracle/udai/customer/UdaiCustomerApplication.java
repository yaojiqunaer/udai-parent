package com.oracle.udai.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@MapperScan("com.oracle.udai.customer.domain.mapper")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
@EnableDiscoveryClient
@SpringBootApplication
public class UdaiCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdaiCustomerApplication.class, args);
    }

}
