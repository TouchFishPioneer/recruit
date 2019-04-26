package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.form.StudentDetailForm;

public class StudentDetailParser {
    public static void formParser(StudentDetailForm studentDetailForm, StudentDetail studentDetail) {

        if (studentDetailForm.getName() != null)
            studentDetail.setStudentName(studentDetailForm.getName());

        if (studentDetailForm.getGender() != null)
            studentDetail.setStudentGender(studentDetailForm.getGender());

        if (studentDetailForm.getTel() != null)
            studentDetail.setStudentTel(studentDetailForm.getTel());

        if (studentDetailForm.getBirthday() != null)
            studentDetail.setStudentBirthday(studentDetailForm.getBirthday());

        if (studentDetailForm.getIdentity_number() != null)
            studentDetail.setStudentIdentityNumber(studentDetailForm.getIdentity_number());

        if (studentDetailForm.getAdmission_number() != null)
            studentDetail.setStudentAdmissionNumber(studentDetailForm.getAdmission_number());

        if (studentDetailForm.getRegion() != null)
            studentDetail.setStudentRegion(studentDetailForm.getRegion());

        if (studentDetailForm.getSchool() != null)
            studentDetail.setStudentSchool(studentDetailForm.getSchool());

        if (studentDetailForm.getMark() != null)
            studentDetail.setStudentMark(studentDetailForm.getMark());

        if (studentDetailForm.getDivision() != null)
            studentDetail.setStudentDivision(studentDetailForm.getDivision());

        if (studentDetailForm.getRank() != null)
            studentDetail.setStudentRank(studentDetailForm.getRank());

        if (studentDetailForm.getRemarks() != null)
            studentDetail.setStudentRemarks(studentDetailForm.getRemarks());

        if (studentDetailForm.getIntentional_major() != null)
            studentDetail.setStudentIntentionalMajor(studentDetailForm.getIntentional_major());

        if (studentDetailForm.getUnintentional_major() != null)
            studentDetail.setStudentUnintentionalMajor(studentDetailForm.getUnintentional_major());

        if (studentDetailForm.getGrade() != null)
            studentDetail.setStudentGrade(studentDetailForm.getGrade());

        if (studentDetailForm.getInfo_source() != null)
            studentDetail.setStudentInfoSource(studentDetailForm.getInfo_source());

        if (studentDetailForm.getContact_status() != null) {
            studentDetail.setStudentContactStatus(studentDetailForm.getContact_status());
        }
    }
}
