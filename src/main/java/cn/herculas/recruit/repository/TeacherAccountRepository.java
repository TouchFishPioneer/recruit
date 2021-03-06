package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherAccountRepository extends JpaRepository<TeacherAccount, Integer> {
    TeacherAccount findByTeacherUsername(String teacherUsername);
    TeacherAccount findByTeacherUuid(String teacherUuid);
}
