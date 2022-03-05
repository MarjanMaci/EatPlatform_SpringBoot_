package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.User;
import com.example.kasnisi.model.exceptions.InvalidArgumentsException;
import com.example.kasnisi.model.exceptions.InvalidUserCredentialsException;
import com.example.kasnisi.repository.UserRepository;
import com.example.kasnisi.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
