package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.UserDto;
import edu.mui.cs489.reachnou.questify.dto.requests.LoginRequest;
import edu.mui.cs489.reachnou.questify.dto.requests.UserRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.UserResponse;
import edu.mui.cs489.reachnou.questify.entity.User;
import edu.mui.cs489.reachnou.questify.exception.BadCredentialsException;
import edu.mui.cs489.reachnou.questify.exception.DuplicatedUserException;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.AuthService;
import edu.mui.cs489.reachnou.questify.service.impl.jwt.UserDetailsImpl;
import edu.mui.cs489.reachnou.questify.util.JwtTokenUtil;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMappingHelper<User, UserDto, UserRequest> modelMappingHelper;

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            UserResponse userResponse = UserDto.userResponse(userDetails.getUser());

            String token = jwtTokenUtil.generateToken(userDetails.getUser());
            userResponse.setToken(token);

            return userResponse;
        }catch (BadCredentialsException exception){
            throw new BadCredentialsException("Username password invalid!");
        }
    }

    @Override
    public UserDto registerUser(UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()) != null) throw new DuplicatedUserException("Username already exist!");
        var user = modelMappingHelper.convertRequestToEntity(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        var result = userRepository.save(user);
        return modelMappingHelper.convertEntityToDto(result, UserDto.class);
    }
}
