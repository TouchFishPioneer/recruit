package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class QuestionForm {
    private String region;
    private String asker_uuid;
    private String theme;
    private Integer category;
    private String tag;
    private Integer status;
    private String content;
    private Integer vote;
    private String answer;
    private String answerer_uuid;
    private String uuid;
}
