package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findByQuestionUuid(String questionUuid);
}
