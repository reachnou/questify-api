package edu.mui.cs489.reachnou.questify.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicDto {
    private Long id;
    private String name;
    private List<QuestionDto> questions;
}
