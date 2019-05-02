package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.data.VO.TeacherAccountVO;

public class TeacherAccountParser {
    public static TeacherAccountVO viewParser(TeacherAccount teacherAccount) {
        TeacherAccountVO teacherAccountVO = new TeacherAccountVO();

        teacherAccountVO.setUsername(teacherAccount.getTeacherUsername());
        teacherAccountVO.setNickname(teacherAccount.getTeacherNickname());
        teacherAccountVO.setRole(teacherAccount.getTeacherRole());
        teacherAccountVO.setStatus(teacherAccount.getTeacherStatus());
        teacherAccountVO.setRegion(teacherAccount.getTeacherRegion());
        teacherAccountVO.setAvatar(teacherAccount.getTeacherAvatar());
        teacherAccountVO.setUuid(teacherAccount.getTeacherUuid());

        return teacherAccountVO;
    }
}
