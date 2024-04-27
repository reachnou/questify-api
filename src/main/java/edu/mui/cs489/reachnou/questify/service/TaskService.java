package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.TaskDto;
import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskRequest taskRequest, Long userId);
    TaskDto getTaskById(Long id);
    TaskDto deleteTaskById(Long id);
    List<TaskDto> getAllTasks();
    List<TaskDto> getTasksByUserId(Long userId);
    TaskDto updateTaskById(Long id, TaskRequest taskRequest);
}
