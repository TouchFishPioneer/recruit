package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.StudentAccount;
import cn.herculas.recruit.data.VO.StudentAccountVO;
import cn.herculas.recruit.form.StudentAccountForm;

public class StudentAccountParser {
    public static StudentAccount formParser(StudentAccountForm studentAccountForm) {
        StudentAccount studentAccount = new StudentAccount();

        studentAccount.setStudentEmail(studentAccountForm.getEmail());
        studentAccount.setStudentPassword(studentAccountForm.getPassword());
        studentAccount.setStudentNickname(studentAccountForm.getNickname());
        studentAccount.setStudentStatus(studentAccountForm.getStatus());
        studentAccount.setStudentUuid(studentAccountForm.getUuid());

        return studentAccount;
    }

    public static StudentAccountVO viewParser(StudentAccount studentAccount) {
        StudentAccountVO studentAccountVO = new StudentAccountVO();

        studentAccountVO.setEmail(studentAccount.getStudentEmail());
        studentAccountVO.setNickname(studentAccount.getStudentNickname());
        studentAccountVO.setStatus(studentAccount.getStudentStatus());
        studentAccountVO.setUuid(studentAccount.getStudentUuid());

        return studentAccountVO;
    }
}
