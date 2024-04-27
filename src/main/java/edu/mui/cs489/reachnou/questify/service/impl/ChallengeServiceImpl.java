package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.constants.ChallengeStatus;
import edu.mui.cs489.reachnou.questify.dto.ChallengeDto;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;
import edu.mui.cs489.reachnou.questify.entity.Challenge;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.ChallengeRepository;
import edu.mui.cs489.reachnou.questify.repository.TopicRepository;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.ChallengeService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final ModelMappingHelper<Challenge, ChallengeDto, ChallengeRequest> modelMappingHelper;

    @Override
    public ChallengeDto createChallenge(ChallengeRequest ChallengeRequest) {
        var challenge = Challenge.builder()
                .challengeName(ChallengeRequest.getChallengeName())
                .duration(ChallengeRequest.getDuration())
                .challengeType(ChallengeRequest.getChallengeType())
                .difficulty(ChallengeRequest.getDifficulty())
                .challengeStatus(ChallengeStatus.NOT_YET_START)
                .build();

        var host = userRepository.findById(ChallengeRequest.getHostId()).orElseThrow(() -> new UserNotFoundException("User ID " + ChallengeRequest.getHostId() + " not found!"));
        var topic = topicRepository.findById(ChallengeRequest.getTopicId()).orElseThrow(()-> new ResourceNotFoundException("Topic ID " + ChallengeRequest.getTopicId() + " not found!"));

        challenge.setHost(host);
        challenge.setTopic(topic);
        challenge.setCompetitors(new ArrayList<>());

        var response = challengeRepository.save(challenge);
        return modelMappingHelper.convertEntityToDto(response, ChallengeDto.class);
    }

    @Override
    public ChallengeDto getChallengeById(Long id) {
        var challenge = simpleGetChallengeById(id);
        return modelMappingHelper.convertEntityToDto(challenge, ChallengeDto.class);
    }

    @Override
    public List<ChallengeDto> getAllChallenges() {
        var challenges = challengeRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(challenges, ChallengeDto.class);
    }

    @Override
    public ChallengeDto deleteChallengeById(Long id) {
        var challenge = simpleGetChallengeById(id);
        challengeRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(challenge, ChallengeDto.class);
    }

    @Override
    public ChallengeDto updateChallengeById(ChallengeRequest challengeRequest, Long id) {
        var oldChallenge = simpleGetChallengeById(id);

        oldChallenge.setChallengeName(challengeRequest.getChallengeName());
        oldChallenge.setDuration(challengeRequest.getDuration());
        oldChallenge.setChallengeType(challengeRequest.getChallengeType());
        oldChallenge.setDifficulty(challengeRequest.getDifficulty());
        oldChallenge.setChallengeStatus(challengeRequest.getChallengeStatus());

        var response = challengeRepository.save(oldChallenge);
        return modelMappingHelper.convertEntityToDto(response, ChallengeDto.class);
    }

    @Override
    public List<ChallengeDto> getChallengesByUserId(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID " + userId + " not found!"));
        var challenges = challengeRepository.findAllByHostId(user.getId());
        return modelMappingHelper.convertEntityListToDtoList(challenges, ChallengeDto.class);
    }

    private Challenge simpleGetChallengeById(Long id) {
        return challengeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Challenge ID: " + id + " not found!"));
    }
}
