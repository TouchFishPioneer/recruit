package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.StudentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentInformationService {
    StudentDetail createStudentDetail(StudentDetail studentDetail);
    StudentDetail updateStudentDetail(StudentDetail studentDetail);
    Page<StudentDetail> listStudentDetail(Pageable pageable);
    StudentDetail findStudentDetail(String studentUuid);
}
