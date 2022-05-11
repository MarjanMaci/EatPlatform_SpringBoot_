package com.example.kasnisi.model.dto;

import com.example.kasnisi.model.Role;
import com.example.kasnisi.model.User;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}

