package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.StudentDetail;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.data.VO.StudentDetailVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.StudentDetailForm;
import cn.herculas.recruit.service.StudentInformationService;
import cn.herculas.recruit.util.parser.StudentDetailParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info/student")
public class StudentInformationController {

    private final StudentInformationService studentInformationService;

    public StudentInformationController(StudentInformationService studentInformationService) {
        this.studentInformationService = studentInformationService;
    }

    @GetMapping("/index")
    public ResultVO listStudentDetail(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // TODO: Permission Check

        Page<StudentDetail> studentDetailPage = studentInformationService.listStudentDetail(PageRequest.of(page, size));
        List<StudentDetailVO> studentDetailVOList = new ArrayList<>();
        for (StudentDetail studentDetail : studentDetailPage) {
            studentDetailVOList.add(StudentDetailParser.viewParser(studentDetail));
        }
        return ResultVO.success(studentDetailVOList);
    }

    @GetMapping("/index/{uuid}")
    public ResultVO findStudentDetail(@PathVariable(value = "uuid") String studentUuid) {

        // TODO: Permission Check

        try {
            StudentDetail result = studentInformationService.findStudentDetail(studentUuid);
            return ResultVO.success(StudentDetailParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/index")
    public ResultVO createStudentDetail(@Valid StudentDetailForm studentDetailForm, BindingResult bindingResult) {

        // TODO: Permission Check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        StudentDetail studentDetail = StudentDetailParser.formParser(studentDetailForm);

        try {
            StudentDetail result = studentInformationService.createStudentDetail(studentDetail);
            return ResultVO.success(StudentDetailParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/index")
    public ResultVO updateStudentDetail(@Valid StudentDetailForm studentDetailForm, BindingResult bindingResult) {

        // TODO: Permission Check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        StudentDetail studentDetail = StudentDetailParser.formParser(studentDetailForm);

        try {
            StudentDetail result = studentInformationService.updateStudentDetail(studentDetail);
            return ResultVO.success(StudentDetailParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
