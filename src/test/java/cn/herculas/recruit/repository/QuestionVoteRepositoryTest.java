package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.QuestionVote;
import cn.herculas.recruit.util.generator.KeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionVoteRepositoryTest {

    @Autowired
    private QuestionVoteRepository questionVoteRepository;

    @Test
    public void saveTest() {
        QuestionVote questionVote = new QuestionVote();

        questionVote.setVoteQuestionUuid(KeyGenerator.uuidGenerator());
        questionVote.setVoteStudentUuid(KeyGenerator.uuidGenerator());

        questionVoteRepository.save(questionVote);
    }
}