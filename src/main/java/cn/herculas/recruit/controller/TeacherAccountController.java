package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.TeacherAccountForm;
import cn.herculas.recruit.service.TeacherRegistrationService;
import cn.herculas.recruit.util.parser.TeacherAccountParser;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        TeacherAccount teacherAccount = TeacherAccountParser.formParser(teacherAccountForm);
        if (teacherAccount.getTeacherPassword() != null)
            return ResultVO.error(HttpStatus.FORBIDDEN);

        try {
            TeacherAccount result = teacherRegistrationService.updateTeacherAccount(teacherAccount);
            return ResultVO.success(TeacherAccountParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/password")
    public ResultVO updateTeacherAccountPassword(@RequestParam("old_password") String oldPassword,
                                                 @RequestParam("password") String newPassword,
                                                 @RequestParam("uuid") String teacherUuid) {

        // TODO: Permission check

        TeacherAccount teacherAccount = teacherRegistrationService.findTeacherAccountByUuid(teacherUuid);
        if (!teacherAccount.getTeacherPassword().equals(oldPassword))
            return ResultVO.error(HttpStatus.FORBIDDEN);
        teacherAccount.setTeacherPassword(newPassword);

        try {
            teacherRegistrationService.updateTeacherAccount(teacherAccount);
            return ResultVO.success();
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
