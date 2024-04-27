package edu.mui.cs489.reachnou.questify.dto.responses;

import edu.mui.cs489.reachnou.questify.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private List<Role> roles;
    private String token;
}
