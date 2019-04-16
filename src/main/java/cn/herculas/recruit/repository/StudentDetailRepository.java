package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
    StudentDetail findByStudentUuid(String studentUuid);
}
