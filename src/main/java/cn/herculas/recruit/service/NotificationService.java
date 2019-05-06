package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {
    Page<Notification> listNotification(Pageable pageable);
    Notification createNotification(Notification notification);
}
