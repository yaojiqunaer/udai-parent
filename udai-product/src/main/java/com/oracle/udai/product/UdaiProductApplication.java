package com.oracle.udai.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.oracle.udai.product.domain.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class UdaiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdaiProductApplication.class, args);
    }

}
