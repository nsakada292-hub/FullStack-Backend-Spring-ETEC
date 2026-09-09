package com.example.crud_api_spring2.Exception;

public class StudentInfoNotFound extends RuntimeException {
    public StudentInfoNotFound(String message) {
        super(message);
    }
}
