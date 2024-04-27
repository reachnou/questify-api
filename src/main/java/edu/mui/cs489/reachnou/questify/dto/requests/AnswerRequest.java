package edu.mui.cs489.reachnou.questify.dto.requests;

import edu.mui.cs489.reachnou.questify.constants.AnswerState;
import lombok.Data;

@Data
public class AnswerRequest {
    private String content;
    private AnswerState answerState;
    private Long questionId;
}
