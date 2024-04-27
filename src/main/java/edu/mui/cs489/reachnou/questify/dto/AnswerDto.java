package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.constants.AnswerState;
import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String content;
    private AnswerState answerState;
}
