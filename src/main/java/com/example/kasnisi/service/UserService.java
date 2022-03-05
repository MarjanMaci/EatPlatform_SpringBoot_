package com.example.kasnisi.service;

import com.example.kasnisi.model.Role;
import com.example.kasnisi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname,String address,String email, Long phoneNumber);
}
