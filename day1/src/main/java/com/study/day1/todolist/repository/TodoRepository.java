package com.study.day1.todolist.repository;

import com.study.day1.todolist.model.Todo;

import java.util.List;


public interface TodoRepository {
    List<Todo> findAll();

    Todo findById(Long id);

    Todo save(Todo todo);

    Todo update(Long id, Todo todo);

    boolean deleteById(Long id);
}
