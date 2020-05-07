package com.oracle.udai.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UdaiPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdaiPayApplication.class, args);
    }

}
