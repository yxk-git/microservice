package com.microcode.fraud.service;

import com.microcode.fraud.mapper.FraudMapper;
import com.microcode.fraud.po.Fraud;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/11/21 20:27
 */
@Service
public class FraudService {

    public final FraudMapper fraudMapper;

    public FraudService(FraudMapper fraudMapper) {
        this.fraudMapper = fraudMapper;
    }

    public Fraud fraudCheckHistory(Integer customerId) {
        Fraud fraud = Fraud.builder()
                .customerId(customerId)
                .createAt(LocalDateTime.now())
                .isFraudster(Boolean.FALSE)
                .build();
        fraudMapper.insert(fraud);
        return fraudMapper.selectById(fraud.getId());
    }
}
