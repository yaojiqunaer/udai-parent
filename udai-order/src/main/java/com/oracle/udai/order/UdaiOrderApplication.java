package com.oracle.udai.order;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableHystrixDashboard  //hystrix监控
@EnableFeignClients  //feign远程调用
@MapperScan("com.oracle.udai.domain.mapper")
@EnableDiscoveryClient  //eureka客户端
@EnableCircuitBreaker   //hystrix降级与熔断
@SpringBootApplication
//@SpringCloudApplication代替上面三个注解
public class UdaiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdaiOrderApplication.class, args);
    }


    /**
     * @param
     * @return
     * @description 熔断监控
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }

}
