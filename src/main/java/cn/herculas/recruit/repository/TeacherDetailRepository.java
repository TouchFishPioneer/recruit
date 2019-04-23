package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDetailRepository extends JpaRepository<TeacherDetail, Integer> {
    TeacherDetail findByTeacherCardNumber(String teacherCardNumber);
    TeacherDetail findByTeacherUuid(String teacherUuid);
}
