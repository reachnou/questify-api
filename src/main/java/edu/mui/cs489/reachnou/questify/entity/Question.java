package edu.mui.cs489.reachnou.questify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.mui.cs489.reachnou.questify.constants.Difficulty;
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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answer;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    private Difficulty difficulty;
}
