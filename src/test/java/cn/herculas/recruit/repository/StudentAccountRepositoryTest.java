package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentAccount;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentAccountRepositoryTest {

    @Autowired
    private StudentAccountRepository studentAccountRepository;

    @Test
    public void saveTest() {
        StudentAccount studentAccount = new StudentAccount();

        studentAccount.setStudentEmail("wurahara@163.com");
        studentAccount.setStudentPassword("19941120");
        studentAccount.setStudentStatus(1);
        studentAccount.setStudentUuid(KeyGenerator.uuidGenerator());

        StudentAccount result = studentAccountRepository.save(studentAccount);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void findOneTest() {
        StudentAccount result = studentAccountRepository.findById(1).orElse(null);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void findByUuid() {
        StudentAccount result = studentAccountRepository.findByStudentUuid("259c5cf334654f429bebafc6114b5488");
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}