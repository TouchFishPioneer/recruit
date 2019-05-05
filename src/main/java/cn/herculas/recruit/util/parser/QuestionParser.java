package cn.herculas.recruit.util.parser;

import cn.herculas.recruit.data.DO.Question;
import cn.herculas.recruit.data.VO.QuestionVO;
import cn.herculas.recruit.enumeration.QuestionStatusEnum;
import cn.herculas.recruit.form.QuestionForm;

public class QuestionParser {
    public static Question formParser(QuestionForm questionForm) {
        Question question = new Question();

        question.setQuestionRegion(questionForm.getRegion());
        question.setQuestionAskerUuid(questionForm.getAsker_uuid());
        question.setQuestionTheme(questionForm.getTheme());
        question.setQuestionCategory(questionForm.getCategory());
        question.setQuestionTag(questionForm.getTag());

        if (questionForm.getStatus() == null) {
            question.setQuestionStatus(QuestionStatusEnum.NOT_REVIEWED.getCode());
        } else {
            question.setQuestionStatus(questionForm.getStatus());
        }

        question.setQuestionContent(questionForm.getContent());

        if (questionForm.getVote() == null) {
            question.setQuestionVote(0);
        } else {
            question.setQuestionVote(questionForm.getVote());
        }

        question.setQuestionAnswer(questionForm.getAnswer());
        question.setQuestionAnswererUuid(questionForm.getAnswerer_uuid());
        question.setQuestionUuid(questionForm.getUuid());

        return question;
    }

    public static QuestionVO viewParser(Question question) {
        QuestionVO questionVO = new QuestionVO();

        questionVO.setRegion(question.getQuestionRegion());
        questionVO.setAsker_uuid(question.getQuestionAskerUuid());
        questionVO.setTheme(question.getQuestionTheme());
        questionVO.setCategory(question.getQuestionCategory());
        questionVO.setTag(question.getQuestionTag());
        questionVO.setStatus(question.getQuestionStatus());
        questionVO.setContent(question.getQuestionContent());
        questionVO.setVote(question.getQuestionVote());
        questionVO.setAnswer(question.getQuestionAnswer());
        questionVO.setAnswerer_uuid(question.getQuestionAnswererUuid());
        questionVO.setUuid(question.getQuestionUuid());

        return questionVO;
    }
}
