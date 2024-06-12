package com.example.demo.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class StudentException {


    @ExceptionHandler(StudentValidationException.class)
    public ResponseEntity<?> handleStudentValidationException(StudentValidationException ex){
        return ResponseEntity.status(400).body(Map.of("message",ex.getMessage()));
    }


    @ExceptionHandler(NullPointerException.class)
    public ProblemDetail handleStudentValidationException2(NullPointerException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400),ex.getMessage());
    }


}
