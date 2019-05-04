package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.data.VO.StudentDetailVO;
import cn.herculas.recruit.enumeration.StudentContactStatusEnum;
import cn.herculas.recruit.enumeration.StudentInfoSourceEnum;
import cn.herculas.recruit.form.StudentDetailForm;

public class StudentDetailParser {
    public static StudentDetail formParser(StudentDetailForm studentDetailForm) {
        StudentDetail studentDetail = new StudentDetail();

        studentDetail.setStudentName(studentDetailForm.getName());
        studentDetail.setStudentGender(studentDetailForm.getGender());
        studentDetail.setStudentTel(studentDetailForm.getTel());
        studentDetail.setStudentBirthday(studentDetailForm.getBirthday());
        studentDetail.setStudentIdentityNumber(studentDetailForm.getIdentity_number());
        studentDetail.setStudentAdmissionNumber(studentDetailForm.getAdmission_number());
        studentDetail.setStudentRegion(studentDetailForm.getRegion());
        studentDetail.setStudentSchool(studentDetailForm.getSchool());
        studentDetail.setStudentMark(studentDetailForm.getMark());
        studentDetail.setStudentDivision(studentDetailForm.getDivision());
        studentDetail.setStudentRank(studentDetailForm.getRank());
        studentDetail.setStudentRemarks(studentDetailForm.getRemarks());


        if (studentDetailForm.getInfo_source() != null) {
            studentDetail.setStudentInfoSource(studentDetailForm.getInfo_source());
        } else {
            if (studentDetailForm.getUuid() != null) {
                studentDetail.setStudentInfoSource(StudentInfoSourceEnum.REGISTER.getCode());
            } else {
                studentDetail.setStudentInfoSource(StudentInfoSourceEnum.IMPORT.getCode());
            }
        }

        if (studentDetailForm.getContact_status() != null) {
            studentDetail.setStudentContactStatus(studentDetailForm.getContact_status());
        } else {
            studentDetail.setStudentContactStatus(StudentContactStatusEnum.NOT_CONTACTED.getCode());
        }


        studentDetail.setStudentIntentionalMajor(studentDetailForm.getIntentional_major());
        studentDetail.setStudentUnintentionalMajor(studentDetailForm.getUnintentional_major());
        studentDetail.setStudentGrade(studentDetailForm.getGrade());
        studentDetail.setStudentUuid(studentDetailForm.getUuid());

        return studentDetail;
    }

    public static StudentDetailVO viewParser(StudentDetail studentDetail) {
        StudentDetailVO studentDetailVO = new StudentDetailVO();

        studentDetailVO.setName(studentDetail.getStudentName());
        studentDetailVO.setGender(studentDetail.getStudentGender());
        studentDetailVO.setTel(studentDetail.getStudentTel());
        studentDetailVO.setBirthday(studentDetail.getStudentBirthday());
        studentDetailVO.setIdentity_number(studentDetail.getStudentIdentityNumber());
        studentDetailVO.setAdmission_number(studentDetail.getStudentAdmissionNumber());
        studentDetailVO.setRegion(studentDetail.getStudentRegion());
        studentDetailVO.setSchool(studentDetail.getStudentSchool());
        studentDetailVO.setMark(studentDetail.getStudentMark());
        studentDetailVO.setDivision(studentDetail.getStudentDivision());
        studentDetailVO.setRank(studentDetail.getStudentRank());
        studentDetailVO.setRemarks(studentDetail.getStudentRemarks());
        studentDetailVO.setInfo_source(studentDetail.getStudentInfoSource());
        studentDetailVO.setContact_status(studentDetail.getStudentContactStatus());
        studentDetailVO.setIntentional_major(studentDetail.getStudentIntentionalMajor());
        studentDetailVO.setUnintentional_major(studentDetail.getStudentUnintentionalMajor());
        studentDetailVO.setGrade(studentDetail.getStudentGrade());
        studentDetailVO.setUuid(studentDetail.getStudentUuid());

        return studentDetailVO;
    }
}
