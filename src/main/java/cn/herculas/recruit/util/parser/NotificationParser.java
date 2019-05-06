package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.Notification;
import cn.herculas.recruit.data.VO.NotificationVO;
import cn.herculas.recruit.enumeration.NotificationStatusEnum;
import cn.herculas.recruit.form.NotificationForm;

public class NotificationParser {
    public static Notification formParser(NotificationForm notificationForm) {
        Notification notification = new Notification();

        notification.setNotificationTeacherUuid(notificationForm.getTeacher_uuid());
        notification.setNotificationRegion(notificationForm.getRegion());
        notification.setNotificationTheme(notificationForm.getTheme());
        notification.setNotificationContent(notificationForm.getContent());

        if (notificationForm.getStatus() == null) {
            notification.setNotificationStatus(NotificationStatusEnum.SENDING.getCode());
        } else {
            notification.setNotificationStatus(notificationForm.getStatus());
        }

        notification.setNotificationUuid(notificationForm.getUuid());

        return notification;
    }

    public static NotificationVO viewParser(Notification notification) {
        NotificationVO notificationVO = new NotificationVO();

        notificationVO.setTeacher_uuid(notification.getNotificationTeacherUuid());
        notificationVO.setRegion(notification.getNotificationRegion());
        notificationVO.setTheme(notification.getNotificationTheme());
        notificationVO.setContent(notification.getNotificationContent());
        notificationVO.setStatus(notification.getNotificationStatus());
        notificationVO.setUuid(notification.getNotificationUuid());

        return notificationVO;
    }
}
