package com.muhammad.studentapi.repository;

import com.muhammad.studentapi.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentById(int id);
}
