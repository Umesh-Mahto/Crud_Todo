package com.geekster.TODO.CRUD.service;

import com.geekster.TODO.CRUD.model.Todo;
import com.geekster.TODO.CRUD.repository.ITodoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    ITodoRepo todoRepo;

    public String addTodo(Todo todo) {
        todoRepo.save(todo);
        return "todo added";
    }

    public Iterable<Todo> getAllTodo() {
        return todoRepo.findAll();
    }

    public Optional<Todo> getTodoById(Integer todoId) {
        return todoRepo.findById(todoId);
    }

    @Transactional
    public String updateTodo(Todo todo) {
        todoRepo.updateTodo(todo.getTodoId(),todo.getTodoName(),todo.getTodoStatus());
        return "updated successfully";
    }

    public String deleteById(Integer todoId) {
        todoRepo.deleteById(todoId);
        return "deleted todoId successfully";
    }
}
