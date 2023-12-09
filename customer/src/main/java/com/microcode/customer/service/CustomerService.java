package com.microcode.customer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microcode.customer.mapper.CustomerMapper;
import com.microcode.customer.po.Customer;
import com.microcode.customer.po.FraudResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    public void saveCustomer(Customer customer) {
        customerMapper.insert(customer);
        ResponseEntity<FraudResponse> FraudResponse = restTemplate.exchange("http://localhost:8082/api/v1/fraud/fraud-check/{customerId}", HttpMethod.GET, HttpEntity.EMPTY, FraudResponse.class, customer.getId());
        if (!Objects.requireNonNull(FraudResponse.getBody()).getIsFraudster()) {
            log.info("这个客户{}不是欺骗者",customer.getId());
        } else {
            log.info("这个客户{}是欺骗者",customer.getId());
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
