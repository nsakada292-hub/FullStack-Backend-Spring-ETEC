package com.example.ass_users_brands.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
    @ExceptionHandler(UserInfoNotFound.class)
    public ResponseEntity<?> handleUserInfoNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(BrandInfoNotFound.class)
    public ResponseEntity<?> handleBrandInfoNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
