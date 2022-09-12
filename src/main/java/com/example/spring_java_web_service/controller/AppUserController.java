package com.example.spring_java_web_service.controller;


import com.example.spring_java_web_service.dto.DtoRequest;
import com.example.spring_java_web_service.dto.DtoResponse;
import com.example.spring_java_web_service.entities.AppUserEntity;
import com.example.spring_java_web_service.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appuser")
//Cors enabled in controller when exposing apps(apis) to other endpoints
@CrossOrigin
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



    @GetMapping
    public List<DtoResponse> findAll(@RequestParam(required = false, defaultValue = "") String contains) {
        return appUserService.findAll(contains);
    }
    @GetMapping("/{id}")
    public DtoResponse findById(@PathVariable int id){
        return appUserService.findById(id);
    }

    @PostMapping
    public DtoResponse insertAppUserEntity(@RequestBody DtoRequest dtoRequest) {
        return appUserService.insertAppUserEntity(dtoRequest);
    }
    //med patch och put ersätter du information som redan finns, patch modifierar du några delar medans put modifierar du hela
    @PatchMapping("/{id}")
    public DtoResponse uppdateById(@PathVariable int id,@RequestBody DtoRequest dtoRequest){
        return appUserService.uppdateById(id,dtoRequest);
    }

}
