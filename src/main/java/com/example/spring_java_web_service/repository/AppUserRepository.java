package com.example.spring_java_web_service.repository;

import com.example.spring_java_web_service.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity,Integer> {

    AppUserEntity findByUsername(String userName);
    List<AppUserEntity> findAppUserEntityByUsernameContaining(String containing);

}
