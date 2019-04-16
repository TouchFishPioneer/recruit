package cn.herculas.recruit.data.DO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private Boolean studentGender;
    private String studentTel;
    private Date studentBirthday;
    private String studentIdentityNumber;
    private String studentAdmissionNumber;
    private String studentRegion;
    private String studentSchool;
    private Integer studentMark;
    private Integer studentDivision;
    private Integer studentRank;
    private String studentRemarks;
    private Integer studentInfoSource;
    private Integer studentContactStatus;
    private String studentIntentionalMajor;
    private String studentUnintentionalMajor;
    private Integer studentGrade;
    private String studentUuid;
}
