package edu.mui.cs489.reachnou.questify.repository;

import edu.mui.cs489.reachnou.questify.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTopicId(Long topicId);
}
