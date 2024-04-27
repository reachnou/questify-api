package edu.mui.cs489.reachnou.questify.dto.requests;

import edu.mui.cs489.reachnou.questify.constants.ChallengeStatus;
import edu.mui.cs489.reachnou.questify.constants.ChallengeType;
import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import lombok.Data;

@Data
public class ChallengeRequest {
    private String challengeName;
    private int duration;
    private ChallengeType challengeType;
    private Difficulty difficulty;
    private ChallengeStatus challengeStatus;
    private Long hostId;
    private Long topicId;
}
