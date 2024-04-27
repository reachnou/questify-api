package edu.mui.cs489.reachnou.questify.dto.responses;

import edu.mui.cs489.reachnou.questify.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TopicResponse {
    private Long id;
    private String name;
}
