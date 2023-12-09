package com.microcode.customer.po;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/9/24 21:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /*客户ID自增*/
    private Integer id;

    /*客户首次使用的用户名*/
    private String firstName;

    /*最后一次使用的用户名*/
    private String lastName;

    /*邮箱*/
    private String email;
}
