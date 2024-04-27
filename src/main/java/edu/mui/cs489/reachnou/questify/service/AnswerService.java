package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.AnswerDto;
import edu.mui.cs489.reachnou.questify.dto.requests.AnswerRequest;

public interface AnswerService {
    AnswerDto createAnswer(AnswerRequest answerRequest);
    AnswerDto deleteAnswerById(Long id);
}
