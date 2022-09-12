package com.example.spring_java_web_service.repository;

import com.example.spring_java_web_service.entities.AppUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {


    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInit(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.appUserRepository.deleteAll();

        appUserRepository.save(new AppUserEntity("admin",passwordEncoder.encode("password") ));

    }


}
