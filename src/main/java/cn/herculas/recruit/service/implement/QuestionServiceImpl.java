package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.data.DO.Question;
import cn.herculas.recruit.data.DO.QuestionVote;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.exception.RecruitException;
import cn.herculas.recruit.repository.QuestionRepository;
import cn.herculas.recruit.repository.QuestionVoteRepository;
import cn.herculas.recruit.service.QuestionService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import cn.herculas.recruit.util.replicator.PropertyReplicator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionVoteRepository questionVoteRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionVoteRepository questionVoteRepository) {
        this.questionRepository = questionRepository;
        this.questionVoteRepository = questionVoteRepository;
    }

    @Override
    public Page<Question> listQuestion(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question findQuestion(String questionUuid) {
        Question question = questionRepository.findByQuestionUuid(questionUuid);
        if (question == null)
            throw new RecruitException(ExceptionStatusEnum.QUESTION_NOT_EXIST);
        return question;
    }

    @Override
    public Question createQuestion(Question question) {
        if (question.getQuestionUuid() == null)
            question.setQuestionUuid(KeyGenerator.uuidGenerator());
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question oldQuestion = questionRepository.findByQuestionUuid(question.getQuestionUuid());
        if (oldQuestion == null)
            throw new RecruitException(ExceptionStatusEnum.QUESTION_NOT_EXIST);
        PropertyReplicator.copyPropertiesIgnoreNull(question, oldQuestion);
        return questionRepository.save(oldQuestion);
    }

    @Override
    public Question voteForQuestion(String questionUuid, String studentUuid) {

        Question question = questionRepository.findByQuestionUuid(questionUuid);
        if (question == null)
            throw new RecruitException(ExceptionStatusEnum.QUESTION_NOT_EXIST);

        QuestionVote questionVote = questionVoteRepository
                .findByVoteQuestionUuidAndVoteStudentUuid(questionUuid, studentUuid);

        if (questionVote == null) {
            QuestionVote newVote = new QuestionVote();
            newVote.setVoteStudentUuid(studentUuid);
            newVote.setVoteQuestionUuid(questionUuid);
            questionVoteRepository.save(newVote);

            question.setQuestionVote(question.getQuestionVote() + 1);
            return questionRepository.save(question);
        } else {
            questionVoteRepository.delete(questionVote);

            Integer vote = question.getQuestionVote();
            question.setQuestionVote((vote - 1) < 0 ? 0 : (vote - 1));
            return questionRepository.save(question);
        }
    }
}
