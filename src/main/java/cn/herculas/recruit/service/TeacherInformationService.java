package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.TeacherDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherInformationService {
    TeacherDetail createTeacherDetail(TeacherDetail teacherDetail);
    TeacherDetail updateTeacherDetail(TeacherDetail teacherDetail);
    Page<TeacherDetail> listTeacherDetail(Pageable pageable);
    TeacherDetail findTeacherDetail(String teacherUuid);
}
