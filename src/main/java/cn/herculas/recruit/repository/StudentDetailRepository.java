package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.data.DTO.StudentContactStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentDivisionStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentGradeStatisticsDTO;
import cn.herculas.recruit.data.DTO.StudentRegionStatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
    StudentDetail findByStudentIdentityNumber(String studentIdentityNumber);
    StudentDetail findByStudentAdmissionNumber(String studentAdmissionNumber);
    StudentDetail findByStudentUuid(String studentUuid);

    @Query("select new cn.herculas.recruit.data.DTO.StudentRegionStatisticsDTO(sd.studentRegion, count(sd)) from StudentDetail sd group by sd.studentRegion")
    List<StudentRegionStatisticsDTO> groupByStudentRegion();
    @Query("select new cn.herculas.recruit.data.DTO.StudentDivisionStatisticsDTO(sd.studentDivision, count(sd)) from StudentDetail sd group by sd.studentDivision")
    List<StudentDivisionStatisticsDTO> groupByStudentDivision();
    @Query("select new cn.herculas.recruit.data.DTO.StudentContactStatisticsDTO(sd.studentContactStatus, count(sd)) from StudentDetail sd group by sd.studentContactStatus")
    List<StudentContactStatisticsDTO> groupByStudentContactStatus();
    @Query("select new cn.herculas.recruit.data.DTO.StudentGradeStatisticsDTO(sd.studentGrade, count(sd)) from StudentDetail sd group by sd.studentGrade")
    List<StudentGradeStatisticsDTO> groupByStudentGrade();
}
