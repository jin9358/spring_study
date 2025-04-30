package com.study.day1.todolist.model;

public record TodoRequest(
        String title,
        String description,
        boolean completed
) {

    public Todo toEntity() {
        return Todo.builder()
                .title(title)
                .description(description)
                .completed(completed)
                .build();
    }
}
