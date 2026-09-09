package com.example.crud_image_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(BookInfoNotFound.class)
    public ResponseEntity<?> handleBookInfoNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) //404
                .body(e.getMessage());
    }
}
