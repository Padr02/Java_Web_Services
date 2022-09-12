package com.example.spring_java_web_service.entities;

//login view model används för att skicka med i request bodin som POST-metod i JSON format
public class LoginViewModel {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
