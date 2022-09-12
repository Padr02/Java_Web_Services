package com.example.spring_java_web_service.service;

import com.example.spring_java_web_service.dto.DtoRequest;
import com.example.spring_java_web_service.dto.DtoResponse;
import com.example.spring_java_web_service.entities.AppUserEntity;
import com.example.spring_java_web_service.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService{


    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }

    public List<DtoResponse> findAll(String contains){
        return appUserRepository.findAppUserEntityByUsernameContaining(contains)
                .stream()
                .map(u -> new DtoResponse(u.getId(),u.getUsername()))
                .toList();
    }

    public DtoResponse findById(int id){
        AppUserEntity appUser = appUserRepository
                .findById(id)
                .orElseThrow();

        return new DtoResponse(appUser.getId(),appUser.getUsername());
    }

    public DtoResponse insertAppUserEntity(DtoRequest dtoRequest){
        AppUserEntity appUser = appUserRepository.save(new AppUserEntity(dtoRequest.userName()));
        return new DtoResponse(appUser.getId(),appUser.getUsername());
    }

    public DtoResponse uppdateById(int id, DtoRequest dtoRequest) {
        AppUserEntity appUser = appUserRepository.findById(id)
                .orElseThrow();
        //finns bibliotek för att kopiera över värden
        if(dtoRequest.userName() != null){
            appUser.setUsername(dtoRequest.userName());
        }
        AppUserEntity createdAppUser = appUserRepository.save(appUser);
        return new DtoResponse(createdAppUser.getId(), createdAppUser.getUsername());

    }
}
