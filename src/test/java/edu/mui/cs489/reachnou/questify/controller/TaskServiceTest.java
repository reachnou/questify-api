//package edu.mui.cs489.reachnou.questify.controller;
//
//import edu.mui.cs489.reachnou.questify.config.TestConfigTest;
//import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
//import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
//import edu.mui.cs489.reachnou.questify.dto.TaskDto;
//import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
//import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
//import edu.mui.cs489.reachnou.questify.service.TaskService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebMvcTest(TaskService.class)
//@ContextConfiguration(classes = TestConfigTest.class)
//class TaskServiceTest {
//    @MockBean
//    private TaskService taskService;
//
//    @Test
//    void testCreateTaskShouldReturnOk() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//        TaskDto taskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        Mockito.when(taskService.createTask(taskRequest, 1L)).thenReturn(taskDto);
//    }
//
//    @Test
//    void testGetAllTasksShouldReturnOk() {
//          LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//          List<TaskDto> tasks = new ArrayList<>();
//          tasks.add(new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null));
//          tasks.add(new TaskDto(2L, "New Task 2", "Description of the new task 2", userDateTime, TaskPriority.HIGH, TaskStatus.IN_PROGRESS, null));
//
//          Mockito.when(taskService.getAllTasks()).thenReturn(tasks);
//    }
//
//    @Test
//    void testGetTaskByIdShouldReturnOk() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskDto taskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        Mockito.when(taskService.getTaskById(1L)).thenReturn(taskDto);
//    }
//
//    @Test
//    void testGetTasksByUserIdShouldReturnOk() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        List<TaskDto> tasks = new ArrayList<>();
//        tasks.add(new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null));
//        tasks.add(new TaskDto(2L, "New Task 2", "Description of the new task 2", userDateTime, TaskPriority.HIGH, TaskStatus.IN_PROGRESS, null));
//
//        Mockito.when(taskService.getTasksByUserId(1L)).thenReturn(tasks);
//    }
//
//    @Test
//    void testUpdateTaskByIdShouldReturnOk() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//        TaskDto taskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        Mockito.when(taskService.updateTaskById(1L, taskRequest)).thenReturn(taskDto);
//    }
//
//    @Test
//    void testDeleteTaskByIdShouldReturnOk() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskDto taskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        Mockito.when(taskService.deleteTaskById(1L)).thenReturn(taskDto);
//    }
//
//    @Test
//    void testCreateTaskShouldReturnNull() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.createTask(taskRequest, 1L)).thenReturn(null);
//    }
//
//    @Test
//    void testUpdateTaskByIdShouldReturnNull() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.updateTaskById(1L, taskRequest)).thenReturn(null);
//    }
//
//    @Test
//    void testGetTaskByIdShouldReturnNull() {
//        Mockito.when(taskService.getTaskById(1L)).thenReturn(null);
//    }
//
//    @Test
//    void testGetTasksByUserIdShouldReturnNull() {
//        Mockito.when(taskService.getTasksByUserId(1L)).thenReturn(null);
//    }
//
//    @Test
//    void testDeleteTaskByIdShouldReturnNull() {
//        Mockito.when(taskService.deleteTaskById(1L)).thenReturn(null);
//    }
//
//    @Test
//    void testGetAllTasksShouldReturnNull() {
//        Mockito.when(taskService.getAllTasks()).thenReturn(null);
//    }
//
//    @Test
//    void testCreateTaskShouldReturnException() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.createTask(taskRequest, 1L)).thenThrow(new UserNotFoundException("User not found!"));
//    }
//
//    @Test
//    void testUpdateTaskByIdShouldReturnException() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.updateTaskById(1L, taskRequest)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetTaskByIdShouldReturnException() {
//        Mockito.when(taskService.getTaskById(1L)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetTasksByUserIdShouldReturnException() {
//        Mockito.when(taskService.getTasksByUserId(1L)).thenThrow(new UserNotFoundException("User not found!"));
//    }
//
//    @Test
//    void testDeleteTaskByIdShouldReturnException() {
//        Mockito.when(taskService.deleteTaskById(1L)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetAllTasksShouldReturnException() {
//        Mockito.when(taskService.getAllTasks()).thenThrow(new UserNotFoundException("No tasks found!"));
//    }
//
//    @Test
//    void testCreateTaskShouldReturnException2() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.createTask(taskRequest, 1L)).thenThrow(new UserNotFoundException("User not found!"));
//    }
//
//    @Test
//    void testUpdateTaskByIdShouldReturnException2() {
//        LocalDateTime userDateTime = LocalDateTime.parse("2020-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//
//        Mockito.when(taskService.updateTaskById(1L, taskRequest)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetTaskByIdShouldReturnException2() {
//        Mockito.when(taskService.getTaskById(1L)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetTasksByUserIdShouldReturnException2() {
//        Mockito.when(taskService.getTasksByUserId(1L)).thenThrow(new UserNotFoundException("User not found!"));
//    }
//
//    @Test
//    void testDeleteTaskByIdShouldReturnException2() {
//        Mockito.when(taskService.deleteTaskById(1L)).thenThrow(new UserNotFoundException("Task ID: 1 not found!"));
//    }
//
//    @Test
//    void testGetAllTasksShouldReturnException2() {
//        Mockito.when(taskService.getAllTasks()).thenThrow(new UserNotFoundException("No tasks found!"));
//    }
//
//}