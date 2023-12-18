package com.microservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clients.po.Notification;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/18 20:19
 */
@Mapper
public interface NotificationMapper extends BaseMapper<Notification> {
}
