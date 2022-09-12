package com.example.spring_java_web_service.controller;


import com.example.spring_java_web_service.dto.Todo;
import com.example.spring_java_web_service.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    //dependency injection kan annoteras med @Autowire
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> findAll(){
        return todoService.findAll();
    }

    @PostMapping
    public Todo insertTodo(@RequestBody Todo todo){
        return  todoService.insertTodo(todo);
    }

}
