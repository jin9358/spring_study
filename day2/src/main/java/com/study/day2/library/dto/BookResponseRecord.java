package com.study.day2.library.dto;

import com.study.day2.library.model.Book;

import java.time.LocalDateTime;
import java.util.List;

public record BookResponseRecord (
        Long id,
        String title,
        String author,
        String isbn,
        String description,
        List<String> categories,
        int publicationYear,
        boolean available,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
    public static BookResponseRecord from(Book book) {
        return new BookResponseRecord(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getDescription(),
                book.getCatagories(),
                book.getPublicationYear(),
                book.isAvailable(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }
}
