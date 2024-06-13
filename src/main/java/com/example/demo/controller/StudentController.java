package com.example.demo.controller;

import com.example.demo.exception.StudentValidationException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

//    @Autowired
//    private StudentService std;


    private final StudentService studentService;


    //Field level injection
//    @Autowired
//    private StudentService studentService;

//    @Autowired  // setter based injection
//    private void setStudentService(StudentService studentService){
//        this.studentService = studentService;
//    }

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    //constructor based injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student){


        LOGGER.info("INFO 2");

        LOGGER.error("ERROR");

        LOGGER.trace("TRACE");

        LOGGER.debug("DEBUG");



        if(student.getName().startsWith("P")) throw new StudentValidationException("Intentionally thrown error");
        if(student.getName().startsWith("A")) throw new NullPointerException("Intentionally thrown error");
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(studentService.findById(id));
        }
        catch (Exception ex){
            LOGGER.error("ERROR OCCURRED {}",ex.getLocalizedMessage());
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentById(@RequestParam(name = "id") Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok("DELETED");
    }
}
