package edu.mui.cs489.reachnou.questify.repository;

import edu.mui.cs489.reachnou.questify.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUserId(Long userId);

}
