package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.StudentAccount;

public interface StudentRegistrationService {
    StudentAccount createStudentAccount(StudentAccount studentAccount);
    StudentAccount updateStudentAccount(StudentAccount studentAccount);
    StudentAccount findStudentAccountByEmail(String studentEmail);
    StudentAccount findStudentAccountByUuid(String studentUuid);
}
