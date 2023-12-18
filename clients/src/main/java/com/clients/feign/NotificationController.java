package com.clients.feign;

import com.clients.po.Notification;
import com.clients.po.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yxk
 * @version 1.0
 * @date 2023/12/18 20:28
 */
@FeignClient(value = "NOTIFICATION",path = "/api/v1/notification")
public interface NotificationController {

    @PostMapping
    ResponseEntity<NotificationResponse> addNotification(@RequestBody Notification notification);

}
