package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.UserDto;
import edu.mui.cs489.reachnou.questify.dto.requests.LoginRequest;
import edu.mui.cs489.reachnou.questify.dto.requests.UserRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.UserResponse;

public interface AuthService {
    UserResponse login(LoginRequest loginRequest);
    UserDto registerUser(UserRequest userRequest) throws Exception;
}
