package com.microcode.customer.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/6 19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudResponse {

    /*主键ID自增*/
    private Integer id;

    /*客户ID*/
    private Integer customerId;

    /*客户是否有欺骗*/
    private Boolean isFraudster;

    /*检测时间*/
    private LocalDateTime createAt;
}
