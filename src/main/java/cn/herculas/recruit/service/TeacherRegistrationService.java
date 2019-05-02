package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.TeacherAccount;

public interface TeacherRegistrationService {
    boolean confirmTeacherAccount(String teacherUsername, String teacherPassword);
    TeacherAccount createTeacherAccount(TeacherAccount teacherAccount);
    TeacherAccount updateTeacherAccount(TeacherAccount teacherAccount);
    TeacherAccount findTeacherAccountByUsername(String teacherUsername);
    TeacherAccount findTeacherAccountByUuid(String teacherUuid);
}
