package edu.mui.cs489.reachnou.questify.repository;

import edu.mui.cs489.reachnou.questify.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
