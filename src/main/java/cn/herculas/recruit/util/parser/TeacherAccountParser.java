package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.data.VO.TeacherAccountVO;
import cn.herculas.recruit.form.TeacherAccountForm;

public class TeacherAccountParser {
    public static TeacherAccount formParser(TeacherAccountForm teacherAccountForm) {
        TeacherAccount teacherAccount = new TeacherAccount();

        teacherAccount.setTeacherUsername(teacherAccountForm.getUsername());
        teacherAccount.setTeacherPassword(teacherAccountForm.getPassword());
        teacherAccount.setTeacherNickname(teacherAccountForm.getNickname());
        teacherAccount.setTeacherRole(teacherAccountForm.getRole());
        teacherAccount.setTeacherStatus(teacherAccountForm.getStatus());
        teacherAccount.setTeacherRegion(teacherAccountForm.getRegion());
        teacherAccount.setTeacherAvatar(teacherAccountForm.getAvatar());
        teacherAccount.setTeacherUuid(teacherAccountForm.getUuid());

        return teacherAccount;
    }

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
