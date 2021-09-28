package com.sam.web.rest;

import com.sam.entities.Course;
import com.sam.reposotories.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @GetMapping("/courses")
    public ResponseEntity getAllCourses() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Course> Courses = courseRepository.findAll();
        System.out.println(Courses);
        return ResponseEntity.ok(Courses);
    }

    @PostMapping("/courses")
    public ResponseEntity save(@RequestBody Course Course) {

        return ResponseEntity.ok(courseRepository.insert(Course));
    }

    @Transactional
    @PutMapping("/courses")
    public ResponseEntity update(@RequestBody Course Course) {

        Course update = courseRepository.save(Course);

        return ResponseEntity.ok(update);
    }

    @Transactional
    @GetMapping("/courses/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {

        Course Course = courseRepository.findById(id).orElse(null);

        return ResponseEntity.ok(Course);
    }

    @Transactional
    @DeleteMapping("/courses/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {

        courseRepository.deleteById(id);

        return ResponseEntity.ok("Course Deleted {}: " + id);
    }
}
