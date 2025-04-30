package com.study.day2.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("도서 ID " + id + "를 찾을 수 없습니다.");
    }

    public BookNotFoundException(String isbn) {
        super("ISBN " + isbn + "에 해당하는 도서를 찾을 수 없습니다.");
    }
}
