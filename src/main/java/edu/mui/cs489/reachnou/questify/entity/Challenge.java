package edu.mui.cs489.reachnou.questify.entity;

import edu.mui.cs489.reachnou.questify.constants.ChallengeStatus;
import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import edu.mui.cs489.reachnou.questify.constants.ChallengeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String challengeName;
    private int duration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;
    @OneToMany
    @JoinTable(
            name = "challenge_participator",
            joinColumns = @JoinColumn(name = "challenge_id"),
            inverseJoinColumns = @JoinColumn(name = "participator_id")
    )
    private List<User> competitors;
    private ChallengeType challengeType;
    private Difficulty difficulty;
    private ChallengeStatus challengeStatus;
}
