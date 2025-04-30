package com.study.day2.service;

import com.study.day2.library.exception.LoanNotFoundException;
import com.study.day2.library.model.Loan;
import com.study.day2.library.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;

    /**
     * 대출 기간 연장
     */
    public Loan extendLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException(loanId));

        if (loan.isExtended()) {
            throw new IllegalStateException("이미 대출 연장이 완료된 건입니다.");
        }

        if (loan.getDueDate().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("기한이 지난 대출은 연장할 수 없습니다.");
        }

        loan.setDueDate(loan.getDueDate().plusDays(7)); // 7일 연장
        loan.setExtended(true);

        return loanRepository.save(loan);
    }
}