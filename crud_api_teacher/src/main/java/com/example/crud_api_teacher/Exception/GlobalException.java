package com.example.crud_api_teacher.Exception;

import com.example.crud_api_teacher.Exception.TeacherInfoNotFound;
import com.example.crud_api_teacher.Exception.TeacherInfoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(TeacherInfoNotFound.class)
    public ResponseEntity<?> handleTeacherInfoNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

//    ResponseEntity<?> — the return type.
//    ResponseEntity is a Spring class representing a complete HTTP response —
//    meaning it holds three things:
//
//    1, A status code (like 404, 200, 500)
//    2, Headers (optional)
//    3, A body (the actual content sent back)
//
//    The <?> is a wildcard generic.
//    Normally you'd write ResponseEntity<String> or ResponseEntity<Teacher>
//    to say exactly what type the body is. <?> means
//    "I'm not committing to one specific type here" —
//    useful because different handler methods in the same class might return different body
//    types(a String here, maybe a custom error object elsewhere).

}