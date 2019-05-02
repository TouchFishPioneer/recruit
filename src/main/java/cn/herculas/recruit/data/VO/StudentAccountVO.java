package cn.herculas.recruit.data.VO;

import lombok.Data;

@Data
public class StudentAccountVO {
    private String email;
    private String nickname;
    private Integer status;
    private String uuid;
}
