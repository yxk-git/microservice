package com.microcode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/24 21:19
 */
@SpringBootApplication
@EnableEurekaClient
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
    }
}
