package com.sam.web.rest;

import com.sam.entities.Student;
import com.sam.reposotories.StudentRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student) {

        Student update = studentRepository.save(student);

        return ResponseEntity.ok(update);
    }

    @Transactional
    @GetMapping("/students/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        return ResponseEntity.ok(student);
    }

    @Transactional
    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {

        studentRepository.deleteById(id);

        return ResponseEntity.ok("Student Deleted {}: " + id);
    }

    @Transactional
    @GetMapping("/students/firstName/{firstName}")
    public  ResponseEntity findOneByFirstName(@PathVariable String firstName) {

        Student oneByFirstName = studentRepository.findOneByFirstName(firstName);
        return ResponseEntity.ok(oneByFirstName);
    }


    @Transactional
    @GetMapping("/students/page")
    public  ResponseEntity findAllByPageable( @ApiParam Pageable pageable) {

        Page<Student> all = studentRepository.findAll(pageable);
        return ResponseEntity.ok(all);
    }





}
