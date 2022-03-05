package com.example.kasnisi.web;

import com.example.kasnisi.model.Role;
import com.example.kasnisi.model.exceptions.InvalidArgumentsException;
import com.example.kasnisi.model.exceptions.PasswordsDoNotMatchException;
import com.example.kasnisi.service.AuthService;
import com.example.kasnisi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String address,
                           @RequestParam String email,
                           @RequestParam String phoneNumber) {
        try{
            Long phoneNumberr=Long.parseLong(phoneNumber);
            this.userService.register(username, password,repeatedPassword,name,surname,address,email,phoneNumberr);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
