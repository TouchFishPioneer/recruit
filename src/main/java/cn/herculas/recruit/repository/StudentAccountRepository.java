package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAccountRepository extends JpaRepository<StudentAccount, Integer> {
    StudentAccount findByStudentUuid(String studentUuid);
}
