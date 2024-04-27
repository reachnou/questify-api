package edu.mui.cs489.reachnou.questify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Long id;
    private User challengerScore;
    private User friendScore;
}
