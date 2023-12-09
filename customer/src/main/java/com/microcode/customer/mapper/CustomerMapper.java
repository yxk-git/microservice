package com.microcode.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microcode.customer.po.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/27 21:19
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
