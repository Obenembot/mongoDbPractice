package com.sam.web.rest;

import com.sam.entities.Student;
import com.sam.reposotories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public ResponseEntity getAllStudents() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students")
    public ResponseEntity save(@RequestBody Student student) {

        return ResponseEntity.ok(studentRepository.insert(student));
    }

    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student) {

        Student update = studentRepository.save(student);

        return ResponseEntity.ok(update);
    }
}
