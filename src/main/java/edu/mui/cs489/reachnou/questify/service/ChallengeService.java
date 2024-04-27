package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.ChallengeDto;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;

import java.util.List;

public interface ChallengeService {
    ChallengeDto createChallenge(ChallengeRequest ChallengeRequest);
    ChallengeDto getChallengeById(Long id);
    List<ChallengeDto> getAllChallenges();
    ChallengeDto deleteChallengeById(Long id);
    ChallengeDto updateChallengeById(ChallengeRequest challengeRequest, Long id);
    List<ChallengeDto> getChallengesByUserId(Long userId);
}
