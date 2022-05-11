package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.Role;
import com.example.kasnisi.model.User;
import com.example.kasnisi.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.kasnisi.model.exceptions.PasswordsDoNotMatchException;
import com.example.kasnisi.model.exceptions.UsernameAlreadyExistsException;
import com.example.kasnisi.repository.UserRepository;
import com.example.kasnisi.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname,String address,String email, Long phoneNumber) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),name,surname,address,email,phoneNumber);
        return userRepository.save(user);
    }


}
