package com.example.kasnisi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_ADMIN,ROLE_ADMIN_RESTAURANT,ROLE_EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }
}

