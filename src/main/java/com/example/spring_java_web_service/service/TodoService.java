package com.example.spring_java_web_service.service;


import com.example.spring_java_web_service.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private WebClient webClient;


    public List<Todo> findAll(){
        return webClient
                .get()
                .uri("/todos")
                //response handler är en funktion som kan ersättas med lambda
                //sedan bodytoflux om ingen kontroll ska göras på statuskoden
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Todo.class))
                .buffer()//lägger till objekt som kommer in
                .blockLast();// här talar vi om att vi inte vill jobba med flux längre
    }


    public Todo insertTodo(Todo todo) {
        return webClient
                .post()
                .uri("/todos")
                .body(Mono.just(todo),Todo.class)
                .exchangeToMono(clientResponse ->  clientResponse.bodyToMono(Todo.class))
                .block();
    }
}
