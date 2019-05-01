package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.StudentDetailRepository;
import cn.herculas.recruit.service.StudentInformationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
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

        if (studentDetail.getStudentUuid() == null)
            studentDetail.setStudentUuid(KeyGenerator.uuidGenerator());

        return studentDetailRepository.save(studentDetail);
    }

    @Override
    public StudentDetail updateStudentDetail(StudentDetail studentDetail) {
        if (studentDetailRepository.findByStudentUuid(studentDetail.getStudentUuid()) == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);

        return studentDetailRepository.save(studentDetail);
    }

    @Override
    public Page<StudentDetail> listStudentDetail(Pageable pageable) {
        return studentDetailRepository.findAll(pageable);
    }

    @Override
    public StudentDetail findStudentDetail(String studentUuid) {
        StudentDetail studentDetail = studentDetailRepository.findByStudentUuid(studentUuid);
        if (studentDetail == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);
        return studentDetail;
    }
}
