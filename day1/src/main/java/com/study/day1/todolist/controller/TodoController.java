package com.study.day1.todolist.controller;

import com.study.day1.todolist.model.Todo;
import com.study.day1.todolist.model.TodoResponse;
import com.study.day1.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;


    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        List<TodoResponse> responses = todos.stream()
                .map(TodoResponse::from)
                .toList();

        return ResponseEntity.ok(responses);
    }
}
