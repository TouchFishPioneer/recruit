package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class NotificationForm {
    private String teacher_uuid;
    private String region;
    private String theme;
    private String content;
    private Integer status;
    private String uuid;
}
