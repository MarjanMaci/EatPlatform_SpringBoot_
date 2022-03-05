package com.example.kasnisi.service;

import com.example.kasnisi.model.User;

public interface AuthService {
    User login(String username, String password);
}
