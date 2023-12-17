package com.microcode.customer.config.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/6 19:42
 */
@Configuration
public class RequestTemplate {

    @Bean
    public RestTemplate createRequestTemplate() {
        return new RestTemplate();
    }
}
