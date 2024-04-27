package edu.mui.cs489.reachnou.questify.service.impl.jwt;

import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username + " : Not found!");
        } else {
            return new UserDetailsImpl(user);
        }
    }
}
