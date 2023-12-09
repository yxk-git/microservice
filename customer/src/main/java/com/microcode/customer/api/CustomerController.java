package com.microcode.customer.api;

import com.microcode.customer.po.Customer;
import com.microcode.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/27 21:15
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> queryCustomers() {
        return customerService.queryCustomers();
    }

    @GetMapping("/{id}")
    public Customer queryCustomerById(@PathVariable Integer id) {
        return customerService.queryCustomerById(id);
    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping()
    public void deleteCustomerById (Integer id) {
        customerService.deleteCustomerById(id);
    }

}
