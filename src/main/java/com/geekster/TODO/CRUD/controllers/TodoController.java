package com.geekster.TODO.CRUD.controllers;

import com.geekster.TODO.CRUD.model.Todo;
import com.geekster.TODO.CRUD.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    TodoService service;
    @PostMapping("/addTodo")
    public String addUser(@Valid @RequestBody Todo todo){
        return service.addTodo(todo);
    }
    @GetMapping("getAllTodo")
    public Iterable<Todo>getAllTodo(){
        return service.getAllTodo();
    }
    @GetMapping("/{todoId}")
    public Optional<Todo> getTodoById(@PathVariable Integer todoId){
        return service.getTodoById(todoId);
    }

    @PutMapping("updateTodo")
    public String updateUser(@RequestBody Todo todo){
        return service.updateTodo(todo);
    }
    @DeleteMapping("/{todoId}")
    public String deleteById(@PathVariable Integer todoId){
        return service.deleteById(todoId);
    }
}
