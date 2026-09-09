package com.example.security_spring.Exception;

public class EmailAndPasswordAreNotMatch extends RuntimeException {
    public EmailAndPasswordAreNotMatch(String message) {
        super(message);
    }
}
