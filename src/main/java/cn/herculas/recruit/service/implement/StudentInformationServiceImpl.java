package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.StudentDetailRepository;
import cn.herculas.recruit.service.StudentInformationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentInformationServiceImpl implements StudentInformationService {

    private final StudentDetailRepository studentDetailRepository;

    public StudentInformationServiceImpl(StudentDetailRepository studentDetailRepository) {
        this.studentDetailRepository = studentDetailRepository;
    }

    @Override
    public StudentDetail createStudentDetail(StudentDetail studentDetail) {
        if (studentDetailRepository.findByStudentIdentityNumber(studentDetail.getStudentIdentityNumber()) != null ||
                studentDetailRepository.findByStudentAdmissionNumber(studentDetail.getStudentAdmissionNumber()) != null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_ALREADY_EXIST);
        return studentDetailRepository.save(studentDetail);
    }

    @Override
    public StudentDetail updateStudentDetail(StudentDetail studentDetail) {
        if (studentDetailRepository.findByStudentUuid(studentDetail.getStudentUuid()) == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);
        return studentDetailRepository.save(studentDetail);
    }

    @Override
    public Page<StudentDetail> findAll(Pageable pageable) {
        return studentDetailRepository.findAll(pageable);
    }

    @Override
    public StudentDetail findOne(String studentUuid) {
        return studentDetailRepository.findByStudentUuid(studentUuid);
    }
}
