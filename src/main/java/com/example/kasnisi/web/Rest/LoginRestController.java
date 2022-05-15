package com.example.kasnisi.web.Rest;

import com.example.kasnisi.auth.fiters.JwtAuthenticationFilter;
import com.example.kasnisi.model.User;
import com.example.kasnisi.model.dto.RestaurantDto;
import com.example.kasnisi.model.dto.UserDTO;
import com.example.kasnisi.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/login")
public class LoginRestController {
    private final UserService userService;
    private final JwtAuthenticationFilter filter;

    public LoginRestController(JwtAuthenticationFilter filter,UserService userService)
    {
        this.filter = filter;
        this.userService=userService;
    }

    @PostMapping
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response) throws JsonProcessingException {
        Authentication auth = this.filter.attemptAuthentication(request, response);
        return this.filter.generateJwt(response, auth);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> doRegister(@RequestBody UserDTO userDTO){
        if(this.userService.register(userDTO.getUsername(),userDTO.getPassword(),userDTO.getRepeatPassword(),userDTO.getName(),userDTO.getSurname(),userDTO.getAddress(),userDTO.getEmail(),Long.parseLong(userDTO.getPhoneNumber()))!=null) {
            return ResponseEntity.ok().body(HttpStatus.CREATED);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


}
