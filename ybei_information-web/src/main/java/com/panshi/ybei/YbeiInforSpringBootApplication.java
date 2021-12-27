package com.panshi.ybei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCircuitBreaker
@EnableDiscoveryClient // 开启Eureka客户端
@EnableFeignClients // 开启Feign功能，一定要记得了
public class YbeiInforSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(YbeiInforSpringBootApplication.class);
    }
}
