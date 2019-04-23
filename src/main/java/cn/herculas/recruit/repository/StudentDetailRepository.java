package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
    StudentDetail findByStudentIdentityNumber(String studentIdentityNumber);
    StudentDetail findByStudentAdmissionNumber(String studentAdmissionNumber);
    StudentDetail findByStudentUuid(String studentUuid);

    List<StudentDetail> findByStudentGrade(Integer studentGrade);
    List<StudentDetail> findByStudentRegion(String studentRegion);
    List<StudentDetail> findByStudentInfoSource(Integer studentInfoSource);
    List<StudentDetail> findByStudentContactStatus(Integer studentContactStatus);
}
