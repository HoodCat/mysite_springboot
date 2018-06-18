package com.github.hoodcat.service;

import org.springframework.stereotype.Service;

import com.github.hoodcat.domain.User;
import com.github.hoodcat.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    
    public void join(User user) {
        userRepository.save(user);
    }
    
    public User getUser(User user) {
        return userRepository.getOne(user.getNo());
    }
    
}
