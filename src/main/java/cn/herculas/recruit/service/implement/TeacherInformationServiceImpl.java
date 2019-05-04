package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.TeacherDetail;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.TeacherDetailRepository;
import cn.herculas.recruit.service.TeacherInformationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherInformationServiceImpl implements TeacherInformationService {

    private final TeacherDetailRepository teacherDetailRepository;

    public TeacherInformationServiceImpl(TeacherDetailRepository teacherDetailRepository) {
        this.teacherDetailRepository = teacherDetailRepository;
    }

    @Override
    public TeacherDetail createTeacherDetail(TeacherDetail teacherDetail) {
        if (teacherDetailRepository.findByTeacherCardNumber(teacherDetail.getTeacherCardNumber()) != null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_ALREADY_EXIST);

        if (teacherDetail.getTeacherUuid() == null)
            teacherDetail.setTeacherUuid(KeyGenerator.uuidGenerator());

        return teacherDetailRepository.save(teacherDetail);
    }

    @Override
    public TeacherDetail updateTeacherDetail(TeacherDetail teacherDetail) {
        TeacherDetail oldTeacherDetail = teacherDetailRepository.findByTeacherUuid(teacherDetail.getTeacherUuid());
        if (oldTeacherDetail == null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_NOT_EXIST);
        PropertyReplicator.copyPropertiesIgnoreNull(teacherDetail, oldTeacherDetail);
        return teacherDetailRepository.save(oldTeacherDetail);
    }

    @Override
    public Page<TeacherDetail> listTeacherDetail(Pageable pageable) {
        return teacherDetailRepository.findAll(pageable);
    }

    @Override
    public TeacherDetail findTeacherDetail(String teacherUuid) {
        TeacherDetail teacherDetail = teacherDetailRepository.findByTeacherUuid(teacherUuid);
        if (teacherDetail == null)
            throw new RecruitException(ExceptionStatusEnum.TEACHER_NOT_EXIST);
        return teacherDetail;
    }
}
