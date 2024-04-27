package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/questify/api/v1/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest, @RequestParam Long userId){
        var task = taskService.createTask(taskRequest, userId);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<?> getAllTask(){
        var tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        var task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getTasksByUserId(@RequestParam Long userId) {
        var tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTaskById(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        var task = taskService.updateTaskById(id, taskRequest);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        var task = taskService.deleteTaskById(id);
        return ResponseEntity.ok(task);
    }
}
