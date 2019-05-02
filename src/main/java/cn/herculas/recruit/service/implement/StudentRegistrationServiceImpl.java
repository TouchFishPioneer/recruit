package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.StudentAccount;
import cn.herculas.recruit.enumeration.AccountStatusEnum;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.StudentAccountRepository;
import cn.herculas.recruit.service.StudentRegistrationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.springframework.stereotype.Service;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    private final StudentAccountRepository studentAccountRepository;

    public StudentRegistrationServiceImpl(StudentAccountRepository studentAccountRepository) {
        this.studentAccountRepository = studentAccountRepository;
    }

    @Override
    public StudentAccount createStudentAccount(StudentAccount studentAccount) {
        if (studentAccountRepository.findByStudentEmail(studentAccount.getStudentEmail()) != null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_ALREADY_EXIST);

        if (studentAccount.getStudentUuid() == null)
            studentAccount.setStudentUuid(KeyGenerator.uuidGenerator());

        if (studentAccount.getStudentStatus() == null)
            studentAccount.setStudentStatus(AccountStatusEnum.VALID.getCode());

        return studentAccountRepository.save(studentAccount);
    }

    @Override
    public StudentAccount updateStudentAccount(StudentAccount studentAccount) {
        if (studentAccountRepository.findByStudentUuid(studentAccount.getStudentUuid()) == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);

        return studentAccountRepository.save(studentAccount);
    }

    @Override
    public StudentAccount findStudentAccountByEmail(String studentEmail) {
        StudentAccount studentAccount = studentAccountRepository.findByStudentEmail(studentEmail);
        if (studentAccount == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);
        return studentAccount;
    }

    @Override
    public StudentAccount findStudentAccountByUuid(String studentUuid) {
        StudentAccount studentAccount = studentAccountRepository.findByStudentUuid(studentUuid);
        if (studentAccount == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);
        return studentAccount;
    }
}
