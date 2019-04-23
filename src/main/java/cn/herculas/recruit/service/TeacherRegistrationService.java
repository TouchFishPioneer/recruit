package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.TeacherAccount;

public interface TeacherRegistrationService {
    TeacherAccount saveTeacherAccount(TeacherAccount teacherAccount);
    TeacherAccount updateTeacherAccount(TeacherAccount teacherAccount);
}
