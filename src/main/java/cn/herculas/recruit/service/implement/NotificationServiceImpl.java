package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.Notification;
import cn.herculas.recruit.repository.NotificationRepository;
import cn.herculas.recruit.service.NotificationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Page<Notification> listNotification(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    public Notification createNotification(Notification notification) {
        if (notification.getNotificationUuid() == null)
            notification.setNotificationUuid(KeyGenerator.uuidGenerator());
        return notificationRepository.save(notification);
    }
}
