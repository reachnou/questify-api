package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.AnswerDto;
import edu.mui.cs489.reachnou.questify.dto.requests.AnswerRequest;
import edu.mui.cs489.reachnou.questify.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/answers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestBody AnswerRequest answerRequest) {
        var answer = answerService.createAnswer(answerRequest);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable Long id) {
        var answer = answerService.deleteAnswerById(id);
        return ResponseEntity.ok(answer);
    }
}
