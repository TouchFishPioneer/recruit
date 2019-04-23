package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.StudentAccount;

public interface StudentRegistrationService {
    StudentAccount saveStudentAccount(StudentAccount studentAccount);
    StudentAccount updateStudentAccount(StudentAccount studentAccount);

}
