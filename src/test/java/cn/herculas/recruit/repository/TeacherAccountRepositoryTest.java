package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherAccountRepositoryTest {

    @Autowired
    private TeacherAccountRepository teacherAccountRepository;

    @Test
    public void saveTest() {
        TeacherAccount teacherAccount = new TeacherAccount();

        teacherAccount.setTeacherUsername("wurahara");
        teacherAccount.setTeacherPassword("19941120");
        teacherAccount.setTeacherStatus(true);
        teacherAccount.setTeacherRegion("332210");
        teacherAccount.setTeacherAvatar("http://avatar.jpg");
        teacherAccount.setTeacherUuid(KeyGenerator.uuidGenerator());

        TeacherAccount result = teacherAccountRepository.save(teacherAccount);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void findOneTest() {
        TeacherAccount teacherAccount = teacherAccountRepository.findById(1).orElse(null);
        Assert.assertNotNull(teacherAccount);
        System.out.println(teacherAccount);
    }

    @Test
    public void findByUuidTest() {
        TeacherAccount teacherAccount = teacherAccountRepository.findByTeacherUuid("88a232cb07be48a0a6403f5f24f4e503");
        Assert.assertNotNull(teacherAccount);
        System.out.println(teacherAccount);
    }
}