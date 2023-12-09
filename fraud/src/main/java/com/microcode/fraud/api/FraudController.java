package com.microcode.fraud.api;

import com.microcode.fraud.po.Fraud;
import com.microcode.fraud.service.FraudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/11/21 20:27
 */
@RestController
@RequestMapping("/api/v1/fraud")
public class FraudController {

    public final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping("/fraud-check/{customerId}")
    public ResponseEntity<Fraud> fraudCheckHistory(@PathVariable Integer customerId) {
        return ResponseEntity.ok(fraudService.fraudCheckHistory(customerId));
    }
}
