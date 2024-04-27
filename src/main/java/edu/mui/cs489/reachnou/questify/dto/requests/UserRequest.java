package edu.mui.cs489.reachnou.questify.dto.requests;

import edu.mui.cs489.reachnou.questify.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private List<Role> roles;
}
