package com.clients.feign;

import com.clients.po.FraudResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/17 16:17
 */
@Component
@FeignClient(value = "FRAUD",path = "/api/v1/fraud")
public interface FraudController {

    @GetMapping("/fraud-check/{customerId}")
    ResponseEntity<FraudResponse> fraudCheckHistory(@PathVariable("customerId") Integer customerId);
}
