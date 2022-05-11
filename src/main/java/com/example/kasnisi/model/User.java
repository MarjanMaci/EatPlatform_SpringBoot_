package com.example.kasnisi.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "user_clients")
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String img;
    private String email;
    private Long phoneNumber;
    @OneToMany(mappedBy = "clientThatOrdered",fetch = FetchType.EAGER)
    private List<Orders> ordersMade;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String username,String password,String name, String surname, String address, String email, Long phoneNumber) {
        this.username=username;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role=Role.ROLE_USER;
    }

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
