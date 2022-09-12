package com.example.spring_java_web_service.controller;

import com.example.spring_java_web_service.dto.JwtRequestDTO;
import com.example.spring_java_web_service.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // json data ut
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody JwtRequestDTO jwtRequestDTO){
       return loginService.authenticate(jwtRequestDTO.username(), jwtRequestDTO.password());
    }

    @GetMapping("/validate")
    public Boolean validate(@RequestParam String token){
        return loginService.validate(token);

    }
}
