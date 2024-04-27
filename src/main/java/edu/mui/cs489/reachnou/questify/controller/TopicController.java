package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.requests.TopicRequest;
import edu.mui.cs489.reachnou.questify.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/topics")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody TopicRequest topicRequest) {
        return ResponseEntity.ok(topicService.createTopic(topicRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopicById(@PathVariable Long id){
        return ResponseEntity.ok(topicService.deleteTopicById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTopicById(@RequestBody TopicRequest topicRequest, @PathVariable Long id){
        return ResponseEntity.ok(topicService.updateTopicById(topicRequest, id));
    }
}
