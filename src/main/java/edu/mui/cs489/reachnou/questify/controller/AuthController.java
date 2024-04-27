package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.requests.LoginRequest;
import edu.mui.cs489.reachnou.questify.dto.requests.UserRequest;
import edu.mui.cs489.reachnou.questify.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) throws Exception {
        var user = authService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        var user =  authService.login(loginRequest);
        return ResponseEntity.ok(user);
    }
}
