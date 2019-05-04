package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.TeacherDetail;
import cn.herculas.recruit.data.VO.TeacherDetailVO;
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
        teacherDetail.setTeacherUuid(teacherDetailForm.getUuid());

        return teacherDetail;
    }

    public static TeacherDetailVO viewParser(TeacherDetail teacherDetail) {
        TeacherDetailVO teacherDetailVO = new TeacherDetailVO();

        teacherDetailVO.setName(teacherDetail.getTeacherName());
        teacherDetailVO.setCard_number(teacherDetail.getTeacherCardNumber());
        teacherDetailVO.setGender(teacherDetail.getTeacherGender());
        teacherDetailVO.setTel(teacherDetail.getTeacherTel());
        teacherDetailVO.setDepartment(teacherDetail.getTeacherDepartment());
        teacherDetailVO.setDuty(teacherDetail.getTeacherDuty());
        teacherDetailVO.setGraduated_school(teacherDetail.getTeacherGraduatedSchool());
        teacherDetailVO.setRemarks(teacherDetail.getTeacherRemarks());
        teacherDetailVO.setUuid(teacherDetail.getTeacherUuid());

        return teacherDetailVO;
    }
}
