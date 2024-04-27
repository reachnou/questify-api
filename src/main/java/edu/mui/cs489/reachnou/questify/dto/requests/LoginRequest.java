package edu.mui.cs489.reachnou.questify.dto.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
