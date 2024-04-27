package edu.mui.cs489.reachnou.questify.dto.requests;

import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import lombok.Data;

@Data
public class QuestionRequest {
    private String content;
    private Difficulty difficulty;
    private Long topicId;
}
