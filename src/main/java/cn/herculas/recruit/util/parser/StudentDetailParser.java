package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.StudentDetail;
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

        studentDetail.setStudentInfoSource(studentDetailForm.getInfo_source());
        studentDetail.setStudentContactStatus(studentDetailForm.getContact_status());

        studentDetail.setStudentIntentionalMajor(studentDetailForm.getIntentional_major());
        studentDetail.setStudentUnintentionalMajor(studentDetailForm.getUnintentional_major());
        studentDetail.setStudentGrade(studentDetailForm.getGrade());

        return studentDetail;
    }
}
