package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.enumeration.AccountStatusEnum;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.TeacherAccountRepository;
import cn.herculas.recruit.service.TeacherRegistrationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.springframework.stereotype.Service;

@Service
public class TeacherRegistrationServiceImpl implements TeacherRegistrationService {

    private final TeacherAccountRepository teacherAccountRepository;

    public TeacherRegistrationServiceImpl(TeacherAccountRepository teacherAccountRepository) {
        this.teacherAccountRepository = teacherAccountRepository;
    }

    @Override
    public boolean confirmTeacherAccount(String teacherUsername, String teacherPassword) {
        TeacherAccount teacherAccount = teacherAccountRepository.findByTeacherUsername(teacherUsername);

        if (teacherAccount == null)
            return false;
        else if (teacherAccount.getTeacherStatus().equals(AccountStatusEnum.DISABLED.getCode()))
            return false;
        else return teacherAccount.getTeacherPassword().equals(teacherPassword);
    }

    @Override
    public TeacherAccount createTeacherAccount(TeacherAccount teacherAccount) {
        if (teacherAccountRepository.findByTeacherUsername(teacherAccount.getTeacherUsername()) != null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_ALREADY_EXIST);

        if (teacherAccount.getTeacherUuid() == null)
            teacherAccount.setTeacherUuid(KeyGenerator.uuidGenerator());

        if (teacherAccount.getTeacherStatus() == null)
            teacherAccount.setTeacherStatus(AccountStatusEnum.VALID.getCode());

        return teacherAccountRepository.save(teacherAccount);
    }

    @Override
    public TeacherAccount updateTeacherAccount(TeacherAccount teacherAccount) {
        if (teacherAccountRepository.findByTeacherUuid(teacherAccount.getTeacherUuid()) == null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_NOT_EXIST);

        return teacherAccountRepository.save(teacherAccount);
    }

    @Override
    public TeacherAccount findTeacherAccountByUsername(String teacherUsername) {
        TeacherAccount teacherAccount = teacherAccountRepository.findByTeacherUsername(teacherUsername);
        if (teacherAccount == null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_NOT_EXIST);
        return teacherAccount;
    }

    @Override
    public TeacherAccount findTeacherAccountByUuid(String teacherUuid) {
        TeacherAccount teacherAccount = teacherAccountRepository.findByTeacherUuid(teacherUuid);
        if (teacherAccount == null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_NOT_EXIST);
        return teacherAccount;
    }
}
