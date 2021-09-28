package com.sam.reposotories;

import com.sam.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends MongoRepository<Course, Long> {
}
