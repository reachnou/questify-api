package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;

import java.util.List;

public interface QuestionService {
    QuestionDto createQuestion(QuestionRequest questionRequest);
    QuestionDto deleteQuestionById(Long id);
    List<QuestionDto> getAllQuestions();
    QuestionDto updateQuestion(Long id, QuestionRequest questionRequest);
    QuestionDto getQuestionById(Long id);
    List<QuestionDto> getRandomQuestionsByTopicId(Long topicId);
}
