package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;
import edu.mui.cs489.reachnou.questify.entity.Question;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.QuestionRepository;
import edu.mui.cs489.reachnou.questify.repository.TopicRepository;
import edu.mui.cs489.reachnou.questify.service.QuestionService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;
    private final ModelMappingHelper<Question, QuestionDto, QuestionRequest> modelMappingHelper;
    @Override
    public QuestionDto createQuestion(QuestionRequest questionRequest) {
        var topic = topicRepository.findById(questionRequest.getTopicId()).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        var question = Question.builder()
                        .content(questionRequest.getContent())
                                .difficulty(questionRequest.getDifficulty())
                                        .topic(topic)
                                                .build();
        var response = questionRepository.save(question);
        return modelMappingHelper.convertEntityToDto(response, QuestionDto.class);
    }

    @Override
    public QuestionDto deleteQuestionById(Long id) {
        var question = simpleGetQuestionById(id);
        questionRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        var questions = questionRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(questions, QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(Long id, QuestionRequest questionRequest) {
        var question = simpleGetQuestionById(id);
        var topic = topicRepository.findById(questionRequest.getTopicId()).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        question.setContent(questionRequest.getContent());
        question.setDifficulty(questionRequest.getDifficulty());
        question.setTopic(topic);
        var response = questionRepository.save(question);
        return modelMappingHelper.convertEntityToDto(response, QuestionDto.class);
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        var question = simpleGetQuestionById(id);
        return modelMappingHelper.convertEntityToDto(question, QuestionDto.class);
    }


    private Question simpleGetQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found"));
    }

    @Override
    public List<QuestionDto> getRandomQuestionsByTopicId(Long topicId) {
        var questions = questionRepository.findAllByTopicId(topicId);
        Collections.shuffle(questions);
        int numRandomQuestions = 10;
        var randomQuestions = questions.subList(0, Math.min(numRandomQuestions, questions.size()));
        return modelMappingHelper.convertEntityListToDtoList(randomQuestions, QuestionDto.class);
    }
}
