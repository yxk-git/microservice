package com.microcode.fraud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microcode.fraud.po.Fraud;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/11/21 20:27
 */
@Mapper
public interface FraudMapper extends BaseMapper<Fraud> {

}
