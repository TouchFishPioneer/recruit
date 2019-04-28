package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.StudentDetailForm;
import cn.herculas.recruit.service.StudentInformationService;
import cn.herculas.recruit.util.parser.StudentDetailParser;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student/info")
public class StudentInformationController {

    private final StudentInformationService studentInformationService;

    public StudentInformationController(StudentInformationService studentInformationService) {
        this.studentInformationService = studentInformationService;
    }

    @GetMapping("/index")
    public ResultVO listStudentDetail(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Page<StudentDetail> studentDetailPage = studentInformationService.listStudentDetail(PageRequest.of(page, size));
        return ResultVO.success(studentDetailPage.getContent());
    }

    @GetMapping("/index/{uuid}")
    public ResultVO findStudentDetail(@PathVariable(value = "uuid") String studentUuid) {
        StudentDetail studentDetail;
        try {
            studentDetail = studentInformationService.findStudentDetail(studentUuid);
        } catch (RecruitException e) {
            return ResultVO.error(404, "NOT FOUND");
        }
        return ResultVO.success(studentDetail);
    }

    @PostMapping("/index")
    public ResultVO createStudentDetail(@Valid StudentDetailForm studentDetailForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RecruitException(ExceptionStatusEnum.INPUT_PARAMS_ERROR);

        StudentDetail studentDetail = StudentDetailParser.formParser(studentDetailForm);
        StudentDetail result;

        try {
            result = studentInformationService.createStudentDetail(studentDetail);
        } catch (RecruitException e) {
            return ResultVO.error(403, "FORBIDDEN");
        }
        return ResultVO.success(result);
    }

    @PatchMapping("/index")
    public ResultVO updateStudentDetail(@Valid StudentDetailForm studentDetailForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RecruitException(ExceptionStatusEnum.INPUT_PARAMS_ERROR);

        StudentDetail studentDetail = studentInformationService.findStudentDetail(studentDetailForm.getUuid());
        StudentDetail studentDetailParams = StudentDetailParser.formParser(studentDetailForm);

        PropertyReplicator.copyPropertiesIgnoreNull(studentDetailParams, studentDetail);
        StudentDetail result;

        try {
            result = studentInformationService.updateStudentDetail(studentDetail);
        } catch (RecruitException e) {
            return ResultVO.error(404, "NOT FOUND");
        }
        return ResultVO.success(result);
    }
}
