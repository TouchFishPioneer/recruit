package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.enumeration.*;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDetailRepositoryTest {

    @Autowired
    private StudentDetailRepository studentDetailRepository;

    @Test
    public void saveTest() {
        StudentDetail studentDetail = new StudentDetail();

        studentDetail.setStudentName("李车干");
        studentDetail.setStudentGender(GenderEnum.MALE.getGenderCode());
        studentDetail.setStudentTel("15651969275");
        studentDetail.setStudentBirthday(new Date());
        studentDetail.setStudentIdentityNumber("321323199411202851");
        studentDetail.setStudentAdmissionNumber("62125147856982345345");
        studentDetail.setStudentRegion("621322");
        studentDetail.setStudentSchool("河北省石家庄市第一中学");
        studentDetail.setStudentMark(675);
        studentDetail.setStudentDivision(StudentDivisionEnum.SCIENCE.getStudentDivisionCode());
        studentDetail.setStudentRank(1800);
        studentDetail.setStudentRemarks("无");
        studentDetail.setStudentInfoSource(StudentInfoSourceEnum.REGISTER.getStudentInfoSourceCode());
        studentDetail.setStudentContactStatus(StudentContactStatusEnum.CONTACTED_POSITIVE.getStudentContactStatusCode());
        studentDetail.setStudentIntentionalMajor("{3}");
        studentDetail.setStudentUnintentionalMajor("{2}");
        studentDetail.setStudentGrade(StudentGradeEnum.GRADE_TWELVE.getStudentGradeCode());
        studentDetail.setStudentUuid(KeyGenerator.uuidGenerator());

        StudentDetail result = studentDetailRepository.save(studentDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest() {
        StudentDetail studentDetail = studentDetailRepository.findById(1).orElse(null);
        Assert.assertNotNull(studentDetail);
        System.out.println(studentDetail);
    }

    @Test
    public void findByUuidTest() {
        StudentDetail studentDetail = studentDetailRepository.findByStudentUuid("53e27903a13b4eabb4fd69f8455a60e3");
        Assert.assertNotNull(studentDetail);
        System.out.println(studentDetail);
    }
}