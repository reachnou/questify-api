package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime deadline;
    private TaskPriority priority;
    private TaskStatus status;
    private UserDto user;
}
