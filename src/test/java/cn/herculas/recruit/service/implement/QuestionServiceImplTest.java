package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.Question;
import cn.herculas.recruit.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceImplTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void voteForQuestionTest() {
        Question question = questionService.voteForQuestion("c4495f4937eb445bb48d0c78d0cb2398", "08af02a583424620966b24156a58ea9f");
    }
}