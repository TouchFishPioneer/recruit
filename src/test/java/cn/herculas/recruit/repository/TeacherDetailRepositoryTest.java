package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.TeacherDetail;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDetailRepositoryTest {
    @Autowired
    private TeacherDetailRepository teacherDetailRepository;

    @Test
    public void saveTest() {
        TeacherDetail teacherDetail = new TeacherDetail();

        teacherDetail.setTeacherName("宋宇波波");
        teacherDetail.setTeacherCardNumber("120499872");
        teacherDetail.setTeacherGender(1);
        teacherDetail.setTeacherTel("13851884333");
        teacherDetail.setTeacherDepartment("57");
        teacherDetail.setTeacherDuty("副教授");
        teacherDetail.setTeacherGraduatedSchool("东南大学");
        teacherDetail.setTeacherRemarks("无");
        teacherDetail.setTeacherUuid(KeyGenerator.uuidGenerator());

        TeacherDetail result = teacherDetailRepository.save(teacherDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest() {
        TeacherDetail teacherDetail = teacherDetailRepository.findById(2).orElse(null);
        Assert.assertNotNull(teacherDetail);
        System.out.println(teacherDetail);
    }

    @Test
    public void findByUuidTest() {
        TeacherDetail teacherDetail = teacherDetailRepository.findByTeacherUuid("94f337a78bc54e4c8cb2cf1d6ba65dae");
        Assert.assertNotNull(teacherDetail);
        System.out.println(teacherDetail);
    }
}