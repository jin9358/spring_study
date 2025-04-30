package com.study.day2.service;

import com.study.day2.library.dto.BookRequest;
import com.study.day2.library.model.Book;
import com.study.day2.library.repository.BookRepository;
import com.study.day2.library.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.study.day2.library.exception.BookNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;


    /**
     * 모든 도서조회
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * 새로운 도서 생성
     */

    public Book createBook(BookRequest request) {
        // ISBN 중복 체크
        bookRepository.findByIsbn(request.getIsbn()).ifPresent(book -> {
            throw new IllegalArgumentException("이미 존재하는 ISBN입니다: " + request.getIsbn());
        });

        Book book = request.toEntity();
        return bookRepository.save(book);
    }

    /**
     * 기존 도서 수정
     */
    public Book updateBook(Long id, BookRequest request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        existingBook.updateBook(request);

        return bookRepository.save(existingBook);
    }
}
