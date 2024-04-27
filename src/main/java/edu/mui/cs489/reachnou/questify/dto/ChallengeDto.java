package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.constants.ChallengeStatus;
import edu.mui.cs489.reachnou.questify.constants.ChallengeType;
import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import lombok.Data;

import java.util.List;

@Data
public class ChallengeDto {
    private Long id;
    private String challengeName;
    private int duration;
    private TopicDto topic;
    private UserDto host;
    private List<UserDto> competitors;
    private ChallengeType challengeType;
    private Difficulty difficulty;
    private ChallengeStatus challengeStatus;

}
