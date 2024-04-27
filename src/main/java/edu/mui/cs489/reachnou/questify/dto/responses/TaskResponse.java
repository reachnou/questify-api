package edu.mui.cs489.reachnou.questify.dto.responses;

import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
import edu.mui.cs489.reachnou.questify.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime deadline;
    private TaskPriority priority;
    private TaskStatus status;
    private Long userId;
    private String username;
}
