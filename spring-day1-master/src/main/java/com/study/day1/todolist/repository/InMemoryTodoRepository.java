package com.study.day1.todolist.repository;

import com.study.day1.todolist.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTodoRepository implements TodoRepository {
    private final Map<Long, Todo> todoStore = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public InMemoryTodoRepository() {
        // 초기 샘플 데이터 추가
        Todo todo1 = Todo.builder()
                .title("Spring Boot 학습")
                .description("Spring Boot 기초 개념 익히기")
                .completed(false)
                .build();

        Todo todo2 = Todo.builder()
                .title("REST API 구현")
                .description("Todo 리스트 API 구현하기")
                .completed(false)
                .build();

        Todo todo3 = Todo.builder()
                .title("테스트 코드 작성")
                .description("JUnit을 이용한 테스트 코드 작성하기")
                .completed(false)
                .build();

        save(todo1);
        save(todo2);
        save(todo3);

    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoStore.values());
    }

    @Override
    public Todo findById(Long id) {
        return todoStore.get(id);
    }

    @Override
    public Todo save(Todo todo) {
        Long id = todo.getId();

        if (id == null) {
            id = sequence.getAndIncrement();
            todo.updateId(id);
        }

        if (todo.getCreatedAt() == null) {
            todo.modifyCreatedAt(LocalDateTime.now());
        }

        todoStore.put(id, todo);
        return todo;
    }

    @Override
    public Todo update(Long id, Todo todo) {
        if (!todoStore.containsKey(id)) {
            return null;
        }

        Todo existingTodo = todoStore.get(id);
        existingTodo.updateTitle(todo.getTitle());
        existingTodo.updateDescription(todo.getDescription());
        existingTodo.updateCompleted(todo.isCompleted());
        existingTodo.modifyUpdatedAt(LocalDateTime.now());

        todoStore.put(id, existingTodo);
        return existingTodo;
    }

    @Override
    public boolean deleteById(Long id) {
        return todoStore.remove(id) != null;
    }
}
