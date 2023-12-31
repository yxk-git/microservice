package com.microcode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/24 21:19
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.clients")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
    }
}
