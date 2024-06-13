package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
