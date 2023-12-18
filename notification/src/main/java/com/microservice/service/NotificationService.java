package com.microservice.service;

import com.clients.po.Notification;
import com.microservice.mapper.NotificationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/18 20:21
 */
@Slf4j
@Service
public class NotificationService {

    private final NotificationMapper notificationMapper;

    public NotificationService(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public Notification addNotification(Notification notification) {
        notification.setCreateAt(LocalDateTime.now());
        notificationMapper.insert(notification);
        log.info("通知模块：收到客户模块通知{}",notification);
        return notification;
    }
}
