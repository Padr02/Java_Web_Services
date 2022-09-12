package com.example.spring_java_web_service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    public AppUserEntity() {

    }

    public AppUserEntity(String username) {
        this.username = username;
    }

    public AppUserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
