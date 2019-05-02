package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.StudentAccount;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.StudentAccountForm;
import cn.herculas.recruit.service.StudentRegistrationService;
import cn.herculas.recruit.util.parser.StudentAccountParser;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account/student")
public class StudentAccountController {

    private final StudentRegistrationService studentRegistrationService;

    public StudentAccountController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }

    @PostMapping("/index")
    public ResultVO createStudentAccount(@Valid StudentAccountForm studentAccountForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        StudentAccount studentAccount = StudentAccountParser.formParser(studentAccountForm);

        try {
            StudentAccount result = studentRegistrationService.createStudentAccount(studentAccount);
            return ResultVO.success(StudentAccountParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/index")
    public ResultVO updateStudentAccount(@Valid StudentAccountForm studentAccountForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        StudentAccount studentAccount;

        try {
            studentAccount = studentRegistrationService.findStudentAccountByUuid(studentAccountForm.getUuid());
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.NOT_FOUND);
        }

        StudentAccount studentAccountParams = StudentAccountParser.formParser(studentAccountForm);
        PropertyReplicator.copyPropertiesIgnoreNull(studentAccountParams, studentAccount);

        try {
            StudentAccount result = studentRegistrationService.updateStudentAccount(studentAccount);
            return ResultVO.success(StudentAccountParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
