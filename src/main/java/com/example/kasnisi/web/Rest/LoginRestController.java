package com.example.kasnisi.web.Rest;

import com.example.kasnisi.auth.fiters.JwtAuthenticationFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/login")
public class LoginRestController {

    private final JwtAuthenticationFilter filter;

    public LoginRestController(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }


    @PostMapping
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response) throws JsonProcessingException {
        Authentication auth = this.filter.attemptAuthentication(request, response);
        return this.filter.generateJwt(response, auth);

    }
}
