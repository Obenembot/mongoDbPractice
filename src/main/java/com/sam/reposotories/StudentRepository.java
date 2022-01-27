package com.sam.reposotories;

import com.sam.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    Student findOneByFirstName(String firstName);

    // Paginate over a full-text search result
    Page<Student> findAllBy(TextCriteria criteria, Pageable pageable);

}
