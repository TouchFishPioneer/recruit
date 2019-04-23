package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.StudentDetailForm;
import cn.herculas.recruit.service.StudentInformationService;
import cn.herculas.recruit.util.parser.StudentDetailParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student/information")
public class StudentInformationController {

    private final StudentInformationService studentInformationService;

    public StudentInformationController(StudentInformationService studentInformationService) {
        this.studentInformationService = studentInformationService;
    }

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Page<StudentDetail> studentDetailPage = studentInformationService.findAll(PageRequest.of(page, size));
        return ResultVO.success(studentDetailPage.getContent());
    }

    @GetMapping("/index")
    public ResultVO findStudentDetail(@RequestParam(value = "uuid") String studentUuid) {
        StudentDetail studentDetail = studentInformationService.findOne(studentUuid);
        return ResultVO.success(studentDetail);
    }

    @PostMapping("/index")
    public ResultVO updateStudentDetail(@Valid StudentDetailForm studentDetailForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            throw new RecruitException(ExceptionStatusEnum.INPUT_PARAMS_ERROR);
        }

        StudentDetail studentDetail;
        StudentDetail result;
        try {
            studentDetail = studentInformationService.findOne(studentDetailForm.getUuid());
            StudentDetailParser.formParser(studentDetailForm, studentDetail);
            result = studentInformationService.updateStudentDetail(studentDetail);
        } catch (RecruitException e) {
            return ResultVO.error(404, "NOT FOUND");
        }

        return ResultVO.success(result);
    }

    @PostMapping("/source")
    public ResultVO updateInfoSource(@RequestParam(value = "source") Integer studentInfoSource) {

    }
}
