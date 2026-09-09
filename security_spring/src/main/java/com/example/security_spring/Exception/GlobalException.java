package com.example.security_spring.Exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> handleNotFound(ChangeSetPersister.NotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<?> handleEmailAlreadyExists(EmailAlreadyExists e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
