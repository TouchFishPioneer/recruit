package cn.herculas.recruit.service;

import cn.herculas.recruit.data.DO.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> listQuestion(Pageable pageable);
    Question findQuestion(String questionUuid);
    Question createQuestion(Question question);
    Question updateQuestion(Question question);
    Question voteForQuestion(String questionUuid, String studentUuid);
}
