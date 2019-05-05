package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.Question;
import cn.herculas.recruit.data.VO.QuestionVO;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.enumeration.QuestionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.form.QuestionForm;
import cn.herculas.recruit.service.QuestionService;
import cn.herculas.recruit.util.parser.QuestionParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interactive/question")
public class QuestionController {

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/index")
    public ResultVO listQuestion(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // TODO: Permission check

        Page<Question> questionPage = questionService.listQuestion(PageRequest.of(page, size));
        List<QuestionVO> questionVOList = new ArrayList<>();
        for (Question question : questionPage) {
            questionVOList.add(QuestionParser.viewParser(question));
        }
        return ResultVO.success(questionVOList);
    }

    @PostMapping("/index")
    public ResultVO createQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult) {

        // TODO: Permission check

        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        Question question = QuestionParser.formParser(questionForm);

        try {
            Question result = questionService.createQuestion(question);
            return ResultVO.success(QuestionParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/index/review/{uuid}")
    public ResultVO reviewQuestion(@PathVariable("uuid") String questionUuid,
                                   @RequestParam("status") Integer questionStatus) {

        // TODO: Permission check

        if (!QuestionStatusEnum.contains(questionStatus))
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        Question question = new Question();
        question.setQuestionUuid(questionUuid);
        question.setQuestionStatus(questionStatus);

        return updateQuestion(question);
    }

    @PostMapping("/index/vote/{uuid}")
    public ResultVO voteQuestion(@PathVariable("uuid") String questionUuid,
                                 @RequestParam("student_uuid") String studentUuid) {

        // TODO: Permission check

        try {
            Question result = questionService.voteForQuestion(questionUuid, studentUuid);
            return ResultVO.success(QuestionParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/index/answer/{uuid}")
    public ResultVO answerQuestion(@PathVariable("uuid") String questionUuid,
                                   @RequestParam("answer") String questionAnswer,
                                   @RequestParam("answerer_uuid") String answererUuid) {

        // TODO: Permission check

        Question question = new Question();
        question.setQuestionUuid(questionUuid);
        question.setQuestionAnswer(questionAnswer);
        question.setQuestionAnswererUuid(answererUuid);

        return updateQuestion(question);
    }

    private ResultVO updateQuestion(Question question) {
        try {
            Question result = questionService.updateQuestion(question);
            return ResultVO.success(QuestionParser.viewParser(result));
        } catch (RecruitException e) {
            return ResultVO.error(HttpStatus.FORBIDDEN);
        }
    }
}
