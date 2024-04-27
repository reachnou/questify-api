package edu.mui.cs489.reachnou.questify.repository;

import edu.mui.cs489.reachnou.questify.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
