//package edu.mui.cs489.reachnou.questify.controller;
//
//import edu.mui.cs489.reachnou.questify.config.TestConfigTest;
//import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
//import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
//import edu.mui.cs489.reachnou.questify.dto.TaskDto;
//import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
//import edu.mui.cs489.reachnou.questify.repository.TaskRepository;
//import edu.mui.cs489.reachnou.questify.service.TaskService;
//import edu.mui.cs489.reachnou.questify.service.impl.TaskServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@MockitoSettings(strictness = Strictness.LENIENT)
//@ContextConfiguration(classes = TestConfigTest.class)
//class TaskServiceIntegrationTest {
//
//    private TaskService taskService;
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @BeforeEach
//    public void setUp() {
//        taskService = new TaskServiceImpl(taskRepository);
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }
//
//
//    @Test
//    void testCreateTaskShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//        TaskDto taskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        TaskDto createdTaskDto = taskService.createTask(taskRequest, 1L);
//
//        assertEquals(taskDto, createdTaskDto);
//    }
//
//    @Test
//    void testGetAllTasksShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        List<TaskDto> expectedTasks = new ArrayList<>();
//        expectedTasks.add(new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null));
//        expectedTasks.add(new TaskDto(2L, "New Task 2", "Description of the new task 2", userDateTime, TaskPriority.HIGH, TaskStatus.IN_PROGRESS, null));
//
//        List<TaskDto> tasks = taskService.getAllTasks();
//
//        assertEquals(expectedTasks, tasks);
//    }
//
//    @Test
//    void testGetTaskByIdShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskDto expectedTaskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        TaskDto taskDto = taskService.getTaskById(1L);
//
//        assertEquals(expectedTaskDto, taskDto);
//    }
//
//    @Test
//    void testGetTasksByUserIdShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        List<TaskDto> expectedTasks = new ArrayList<>();
//        expectedTasks.add(new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null));
//        expectedTasks.add(new TaskDto(2L, "New Task 2", "Description of the new task 2", userDateTime, TaskPriority.HIGH, TaskStatus.IN_PROGRESS, null));
//
//        List<TaskDto> tasks = taskService.getTasksByUserId(1L);
//
//        assertEquals(expectedTasks, tasks);
//    }
//
//    @Test
//    void testUpdateTaskByIdShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskRequest taskRequest = new TaskRequest("New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO);
//        TaskDto expectedTaskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        TaskDto updatedTaskDto = taskService.updateTaskById(1L, taskRequest);
//
//        assertEquals(expectedTaskDto, updatedTaskDto);
//    }
//
//    @Test
//    void testDeleteTaskByIdShouldReturnOk() throws Exception {
//        LocalDateTime userDateTime = LocalDateTime.parse("2024-04-30T19:57:39", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        TaskDto expectedTaskDto = new TaskDto(1L, "New Task", "Description of the new task", userDateTime, TaskPriority.LOW, TaskStatus.TODO, null);
//
//        TaskDto deletedTaskDto = taskService.deleteTaskById(1L);
//
//        assertEquals(expectedTaskDto, deletedTaskDto);
//    }
//}
//
