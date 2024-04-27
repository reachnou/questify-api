package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;
import edu.mui.cs489.reachnou.questify.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/questions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody QuestionRequest questionRequest) {
        var question = questionService.createQuestion(questionRequest);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long id) {
        var question = questionService.deleteQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping
    public ResponseEntity<?> getAllQuestions() {
        var questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody QuestionRequest questionRequest) {
        var question = questionService.updateQuestion(id, questionRequest);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {
        var question = questionService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<?> getRandomQuestionsByTopicId(@PathVariable Long topicId) {
        var questions = questionService.getRandomQuestionsByTopicId(topicId);
        return ResponseEntity.ok(questions);
    }
}
