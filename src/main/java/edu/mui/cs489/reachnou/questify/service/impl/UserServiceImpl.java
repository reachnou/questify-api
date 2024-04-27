package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

//    private final UserRepository userRepository;
//
//    @Override
//    public User create(User entity) {
//        var result = userRepository.save(entity);
//        return userRepository.save(result);
//    }
//
//    @Override
//    public User getById(Long id) {
//        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("ID " + id + " not found!"));
//    }
//
//    @Override
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User deleteById(Long id) {
//        var result = getById(id);
//        userRepository.deleteById(id);
//        return result;
//    }
//
//    @Override
//    public User updateById(User entity, Long id) {
//        return null;
//    }
}
