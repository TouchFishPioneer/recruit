package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.TeacherDetail;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.data.VO.TeacherDetailVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.TeacherDetailForm;
import cn.herculas.recruit.service.TeacherInformationService;
import cn.herculas.recruit.util.parser.TeacherDetailParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info/teacher")
public class TeacherInformationController {

    private final TeacherInformationService teacherInformationService;

    public TeacherInformationController(TeacherInformationService teacherInformationService) {
        this.teacherInformationService = teacherInformationService;
    }

    @GetMapping("/index")
    public ResultVO listTeacherDetail(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // TODO: Permission Check

        Page<TeacherDetail> teacherDetailPage = teacherInformationService.listTeacherDetail(PageRequest.of(page, size));
        List<TeacherDetailVO> teacherDetailVOList = new ArrayList<>();
        for (TeacherDetail teacherDetail : teacherDetailPage) {
            teacherDetailVOList.add(TeacherDetailParser.viewParser(teacherDetail));
        }
        return ResultVO.success(teacherDetailVOList);
    }

    @GetMapping("/index/{uuid}")
    public ResultVO findTeacherDetail(@PathVariable(value = "uuid") String teacherUuid) {

        // TODO: Permission Check

        try {
            TeacherDetail teacherDetail = teacherInformationService.findTeacherDetail(teacherUuid);
            return ResultVO.success(TeacherDetailParser.viewParser(teacherDetail));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/index")
    public ResultVO createTeacherDetail(@Valid TeacherDetailForm teacherDetailForm, BindingResult bindingResult) {

        // TODO: Permission Check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        TeacherDetail teacherDetail = TeacherDetailParser.formParser(teacherDetailForm);

        try {
            TeacherDetail result = teacherInformationService.createTeacherDetail(teacherDetail);
            return ResultVO.success(TeacherDetailParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/index")
    public ResultVO updateTeacherDetail(@Valid TeacherDetailForm teacherDetailForm, BindingResult bindingResult) {

        // TODO: Permission Check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        TeacherDetail teacherDetail = TeacherDetailParser.formParser(teacherDetailForm);

        try {
            TeacherDetail result = teacherInformationService.updateTeacherDetail(teacherDetail);
            return ResultVO.success(TeacherDetailParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
