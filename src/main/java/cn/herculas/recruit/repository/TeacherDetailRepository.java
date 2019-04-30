package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDetailRepository extends JpaRepository<TeacherDetail, Integer> {
    TeacherDetail findByTeacherUuid(String teacherUuid);
    TeacherDetail findByTeacherCardNumber(String teacherCardNumber);
}
