package com.clients.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/18 20:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    /*通知模块的自增ID*/
    private Integer id;

    /*客户ID*/
    private Integer customerId;

    /*欺骗鉴定ID*/
    private Integer fraudId;

    /*是否是欺骗者*/
    private Boolean isFraudster;

    /*时间戳*/
    private LocalDateTime createAt;
}
