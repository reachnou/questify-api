package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import edu.mui.cs489.reachnou.questify.entity.Answer;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String content;
    private List<AnswerDto> answer;
    private Difficulty difficulty;
}
