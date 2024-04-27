package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.TaskDto;
import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.entity.Task;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.TaskRepository;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.TaskService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ModelMappingHelper<Task, TaskDto, TaskRequest> modelMappingHelper;

    @Override
    public TaskDto createTask(TaskRequest taskRequest, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found!"));

        if (isDateTimeInputNotInThePast(taskRequest.getDeadline())) {
            var task = modelMappingHelper.convertRequestToEntity(taskRequest, Task.class);
            task.setUser(user);

            var result = taskRepository.save(task);

            return modelMappingHelper.convertEntityToDto(result, TaskDto.class);
        }
        return null;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        var task = simpleFindTaskById(id);
        return modelMappingHelper.convertEntityToDto(task, TaskDto.class);
    }

    @Override
    public TaskDto deleteTaskById(Long id) {
        var task = simpleFindTaskById(id);
        taskRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(task, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        var tasks = taskRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(tasks, TaskDto.class);
    }

    @Override
    public List<TaskDto> getTasksByUserId(Long userId) {
        var tasks = taskRepository.findTasksByUserId(userId);
        return modelMappingHelper.convertEntityListToDtoList(tasks, TaskDto.class);
    }

    @Override
    public TaskDto updateTaskById(Long id, TaskRequest taskRequest) {
        var oldTask = simpleFindTaskById(id);

        LocalDateTime userDateTime = LocalDateTime.parse(taskRequest.getDeadline().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        oldTask.setName(taskRequest.getName());
        oldTask.setDescription(taskRequest.getDescription());
        oldTask.setDeadline(userDateTime);
        oldTask.setPriority(taskRequest.getPriority());
        oldTask.setStatus(taskRequest.getStatus());

        var response = taskRepository.save(oldTask);
        return modelMappingHelper.convertEntityToDto(response, TaskDto.class);
    }

    private Task simpleFindTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Task ID: " + id + " not found!"));
    }

    private boolean isDateTimeInputNotInThePast(LocalDateTime localDateTime) {
        try {
            LocalDateTime userDateTime = LocalDateTime.parse(localDateTime.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime now = LocalDateTime.now();

            if (userDateTime.isBefore(now)) {
                throw new IllegalArgumentException("User input date and time is less than the current date and time.");
            } else {
                return true;
            }
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date time format provided.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
