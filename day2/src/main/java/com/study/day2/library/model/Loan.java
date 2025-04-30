package com.study.day2.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/*
    loan : 도서 대출 정보를 나타 내는 모델 클래스
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Setter
    private Long id;
    private Book book;
    private Member member;
    @Setter
    private LocalDateTime loanDate;
    @Setter
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private boolean returned;
    private boolean extended;   // 연장

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDateTime.now();
        this.dueDate = this.loanDate.plusDays(14);
        this.returned = false;
        this.extended = false;
    }

    public void returnBook() {
        this.returned = true;
        this.returnDate = LocalDateTime.now();
        if(this.book != null) {
            this.book.setAvailable(true);
        }
    }

    public boolean isOverdue() {
        if (this.returned) {
            return false;
        }
        return LocalDateTime.now().isAfter(this.dueDate);
    }
}
