package edu.mui.cs489.reachnou.questify.entity;

import edu.mui.cs489.reachnou.questify.constants.AnswerState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private AnswerState answerState;
}
