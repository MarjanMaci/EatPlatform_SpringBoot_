package com.example.kasnisi.model.dto;

import com.example.kasnisi.model.Orders;
import com.example.kasnisi.model.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String repeatPassword;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String repeatPassword, String name, String surname, String address, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
