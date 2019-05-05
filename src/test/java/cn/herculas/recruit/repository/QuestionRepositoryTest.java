package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.Question;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void saveTest() {
        Question question = new Question();

        question.setQuestionRegion("001122");
        question.setQuestionAskerUuid(KeyGenerator.uuidGenerator());
        question.setQuestionTheme("母猪的产后护理");
        question.setQuestionStatus(0);
        question.setQuestionContent("你说你🐎呢");
        question.setQuestionVote(0);
        question.setQuestionAnswererUuid(KeyGenerator.uuidGenerator());
        question.setQuestionUuid(KeyGenerator.uuidGenerator());

        questionRepository.save(question);
    }
}