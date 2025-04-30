package com.study.day1.todolist.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Builder
@Getter
@ToString
public class Todo {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateId(Long id) {
        this.id = id;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateCompleted(boolean completed) {
        this.completed = completed;
    }

    public void modifyCreatedAt(LocalDateTime modifiedAt) {
        this.createdAt = modifiedAt;
    }

    public void modifyUpdatedAt(LocalDateTime modifiedAt) {
        this.updatedAt = modifiedAt;
    }
}
