package com.microcode.customer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clients.feign.FraudController;
import com.clients.feign.NotificationController;
import com.clients.po.FraudResponse;
import com.clients.po.Notification;
import com.clients.po.NotificationResponse;
import com.microcode.customer.mapper.CustomerMapper;
import com.microcode.customer.po.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/27 21:17
 */
@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FraudController fraudController;

    @Autowired
    private NotificationController notificationController;

    public void saveCustomer(Customer customer) {
        customerMapper.insert(customer);
        ResponseEntity<FraudResponse> fraudResponse = fraudController.fraudCheckHistory(customer.getId());
        log.info("欺骗模块：欺骗模块的回复{}",fraudResponse);
        if (fraudResponse != null && fraudResponse.getBody() != null) {
            ResponseEntity<NotificationResponse> notification = notificationController
                    .addNotification(Notification
                            .builder()
                            .customerId(customer.getId())
                            .fraudId(fraudResponse.getBody().getId())
                            .isFraudster(fraudResponse.getBody().getIsFraudster())
                            .build());
            log.info("通知模块：通知模块的回复{}",notification);
            if (!Objects.requireNonNull(fraudResponse.getBody()).getIsFraudster()) {
                log.info("这个客户{}不是欺骗者",customer.getId());
            } else {
                log.info("这个客户{}是欺骗者",customer.getId());
            }
        }
    }

    public List<Customer> queryCustomers() {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        return customerMapper.selectList(queryWrapper);
    }

    public Customer queryCustomerById(Integer id) {
        return customerMapper.selectById(id);
    }

    public void updateCustomer(Customer customer) {
        customerMapper.updateById(customer);
    }

    public void deleteCustomerById(Integer id) {
        customerMapper.deleteById(id);
    }
}
