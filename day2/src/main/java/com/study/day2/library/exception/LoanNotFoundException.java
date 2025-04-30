package com.study.day2.library.exception;

public class LoanNotFoundException extends RuntimeException {
  public LoanNotFoundException(Long id) {
    super("Loan ID " + id + " 에 해당하는 도서 대출 내역이 없습니다.");
  }
}