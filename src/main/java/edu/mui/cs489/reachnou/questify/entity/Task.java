package edu.mui.cs489.reachnou.questify.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @FutureOrPresent(message = "Invalid date!")
    private LocalDateTime deadline;
    private TaskPriority priority;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
