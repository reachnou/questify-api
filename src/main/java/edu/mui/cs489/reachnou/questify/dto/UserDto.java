package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.dto.responses.UserResponse;
import edu.mui.cs489.reachnou.questify.entity.Role;
import edu.mui.cs489.reachnou.questify.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private List<Role> roles;

    public static UserResponse userResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
