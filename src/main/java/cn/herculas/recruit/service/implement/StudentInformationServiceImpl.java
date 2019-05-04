package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.enumeration.StudentInfoSourceEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.StudentDetailRepository;
import cn.herculas.recruit.service.StudentInformationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
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
        if (studentDetail.getStudentUuid() == null)
            studentDetail.setStudentUuid(KeyGenerator.uuidGenerator());

        // Data source configuration
        // 1. Completely new data
        if (studentDetailRepository.findByStudentIdentityNumber(studentDetail.getStudentIdentityNumber()) == null &&
                studentDetailRepository.findByStudentAdmissionNumber(studentDetail.getStudentAdmissionNumber()) == null) {
            return studentDetailRepository.save(studentDetail);
        } else {
            StudentDetail oldStudentDetail = studentDetailRepository.findByStudentIdentityNumber(studentDetail.getStudentIdentityNumber());
            if (oldStudentDetail == null)
                oldStudentDetail = studentDetailRepository.findByStudentAdmissionNumber(studentDetail.getStudentAdmissionNumber());

            // 2. Teacher imported, and then student initialized
            if (oldStudentDetail.getStudentInfoSource().equals(StudentInfoSourceEnum.IMPORT.getCode())) {
                return this.getStudentDetail(studentDetail, oldStudentDetail);
            }

            // 3. Student initialized, and then teacher imported
            if (oldStudentDetail.getStudentInfoSource().equals(StudentInfoSourceEnum.REGISTER.getCode())) {
                return this.getStudentDetail(oldStudentDetail, studentDetail);
            }

            // 4. Imported and initialized
            if (oldStudentDetail.getStudentInfoSource().equals(StudentInfoSourceEnum.IMPORT_AND_REGISTER.getCode())) {
                throw new RecruitException(ExceptionStatusEnum.STUDENT_ALREADY_EXIST);
            }
        }
        throw new RecruitException(ExceptionStatusEnum.STUDENT_ALREADY_EXIST);
    }

    private StudentDetail getStudentDetail(StudentDetail untrustedSource, StudentDetail trustedSource) {
        Integer studentMark = trustedSource.getStudentMark();
        Integer studentRank = trustedSource.getStudentRank();
        PropertyReplicator.copyPropertiesIgnoreNull(untrustedSource, trustedSource);
        trustedSource.setStudentMark(studentMark);
        trustedSource.setStudentRank(studentRank);
        trustedSource.setStudentInfoSource(StudentInfoSourceEnum.IMPORT_AND_REGISTER.getCode());
        return studentDetailRepository.save(trustedSource);
    }

    @Override
    public StudentDetail updateStudentDetail(StudentDetail studentDetail) {
        StudentDetail oldStudentDetail = studentDetailRepository.findByStudentUuid(studentDetail.getStudentUuid());
        if (oldStudentDetail == null)
            throw new RecruitException(ExceptionStatusEnum.STUDENT_NOT_EXIST);
        PropertyReplicator.copyPropertiesIgnoreNull(studentDetail, oldStudentDetail);
        return studentDetailRepository.save(oldStudentDetail);
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
