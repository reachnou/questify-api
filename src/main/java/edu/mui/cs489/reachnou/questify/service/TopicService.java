package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.TopicDto;
import edu.mui.cs489.reachnou.questify.dto.requests.TopicRequest;

import java.util.List;

public interface TopicService {
    TopicDto createTopic(TopicRequest topicRequest);
    TopicDto getTopicById(Long id);
    List<TopicDto> getAllTopics();
    TopicDto deleteTopicById(Long id);
    TopicDto updateTopicById(TopicRequest topicRequest, Long id);
}
