package cn.herculas.recruit.repository;

import cn.herculas.recruit.data.DO.QuestionVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Integer> {
    QuestionVote findByVoteQuestionUuidAndVoteStudentUuid(String voteQuestionUuid, String voteStudentUuid);
}
