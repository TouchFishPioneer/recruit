package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.TeacherDetail;
import cn.herculas.recruit.form.TeacherDetailForm;

public class TeacherDetailParser {
    public static TeacherDetail formParser(TeacherDetailForm teacherDetailForm) {
        TeacherDetail teacherDetail = new TeacherDetail();

        teacherDetail.setTeacherName(teacherDetailForm.getName());
        teacherDetail.setTeacherCardNumber(teacherDetailForm.getCard_number());
        teacherDetail.setTeacherGender(teacherDetailForm.getGender());
        teacherDetail.setTeacherTel(teacherDetailForm.getTel());
        teacherDetail.setTeacherDepartment(teacherDetailForm.getDepartment());
        teacherDetail.setTeacherDuty(teacherDetailForm.getDuty());
        teacherDetail.setTeacherGraduatedSchool(teacherDetailForm.getGraduated_school());
        teacherDetail.setTeacherRemarks(teacherDetailForm.getRemarks());

        return teacherDetail;
    }
}
