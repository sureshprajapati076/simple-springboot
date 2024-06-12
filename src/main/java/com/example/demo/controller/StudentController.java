package com.example.demo.controller;

import com.example.demo.exception.StudentValidationException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student){
        if(student.getName().startsWith("P")) throw new StudentValidationException("Intentionally thrown error");
        if(student.getName().startsWith("A")) throw new NullPointerException("Intentionally thrown error");
        return ResponseEntity.ok(studentService.addStudent(student));
    }
}
