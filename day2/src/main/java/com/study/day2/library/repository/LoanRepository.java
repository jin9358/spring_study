package com.study.day2.library.repository;

import com.study.day2.library.model.Book;
import com.study.day2.library.model.Loan;
import com.study.day2.library.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class LoanRepository {
    // 로거

    // 동시성 이슈를 고려한 ConcurrentHashMap 구성한 loanStore
    private final Map<Long, Loan> loanStore = new ConcurrentHashMap<>();
    // Id 생성을 위한 AtomicLong 사용
    private final AtomicLong sequence = new AtomicLong(1);
    /**
     * 모든 대출 조회
     */
    public List<Loan> findAll() {
        return new ArrayList<>(loanStore.values());
    }
    /**
     * ID 로 특정 조회(Optional)
     */
    public Optional<Loan> findById(Long id) {
        return Optional.ofNullable(loanStore.get(id));
    }

    /**
     * 회원 ID로 대출 목록 조회
     */
    public List<Loan> findByMemberId(Long memberId) {
        return loanStore.values().stream()
                .filter(loan -> loan.getMember().getId().equals(memberId))
                .collect(Collectors.toList());      // gpt 도움
    }
    /**
     * 도서 Id로 대출 목록 조회
     */
    public List<Loan> findByBookId(Long bookId) {
        return loanStore.values().stream()
                .filter(loan -> loan.getBook().getId().equals(bookId))
                .collect(Collectors.toList());      // gpt 도움
    }
    /**
     * 반납 여부로 대출 목록 필터링
     */

    /**
     * 연체된 대출 목록 조회
     */

    /**
     * 대출 저장(생성/수정)
     */

    /**
     * 대출 삭제
     */

    /**
     * 도서 ID로 대출 삭제
     */
    public void deleteByBookId(Long bookId) {
        loanStore.values().removeIf(loan -> loan.getBook().getId().equals(bookId));
    }

    /**
     * 회원 ID로 대출 삭제
     */
    public void deleteByMemberId(Long memberId) {
        loanStore.values().removeIf(loan -> loan.getMember().getId().equals(memberId));
    }
}
