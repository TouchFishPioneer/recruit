package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherAccountRepository extends JpaRepository<TeacherAccount, Integer> {
    TeacherAccount findByTeacherUsername(String teacherUsername);
    TeacherAccount findByTeacherUuid(String teacherUuid);
    List<TeacherAccount> findByTeacherRegion(String teacherRegion);
}
