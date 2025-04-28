package com.study.day1.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("Member not found with id: " + id);
    }

    public MemberNotFoundException(String email) {
        super("Member not found whit email: " + email);
    }
}
