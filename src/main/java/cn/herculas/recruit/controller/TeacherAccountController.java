package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.data.VO.TeacherAccountVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.TeacherAccountForm;
import cn.herculas.recruit.service.TeacherRegistrationService;
import cn.herculas.recruit.util.parser.TeacherAccountParser;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account/teacher")
public class TeacherAccountController {

    private final TeacherRegistrationService teacherRegistrationService;

    public TeacherAccountController(TeacherRegistrationService teacherRegistrationService) {
        this.teacherRegistrationService = teacherRegistrationService;
    }

    @PostMapping("/index")
    public ResultVO createTeacherAccount(@Valid TeacherAccountForm teacherAccountForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        TeacherAccount teacherAccount = TeacherAccountParser.formParser(teacherAccountForm);

        try {
            TeacherAccount result = teacherRegistrationService.createTeacherAccount(teacherAccount);
            return ResultVO.success(TeacherAccountParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/index")
    public ResultVO updateTeacherAccount(@Valid TeacherAccountForm teacherAccountForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        TeacherAccount teacherAccount;
        try {
            teacherAccount = teacherRegistrationService.findTeacherAccountByUuid(teacherAccountForm.getUuid());
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.NOT_FOUND);
        }

        TeacherAccount teacherAccountParams = TeacherAccountParser.formParser(teacherAccountForm);
        PropertyReplicator.copyPropertiesIgnoreNull(teacherAccountParams, teacherAccount);

        try {
            TeacherAccount result = teacherRegistrationService.updateTeacherAccount(teacherAccount);
            return ResultVO.success(TeacherAccountParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
