package com.muhammad.studentapi.service;
import com.muhammad.studentapi.model.Student;
import com.muhammad.studentapi.repository.StudentRepository;
import org.slf4j.ILoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // try = runs code that may cause an exception
    // catch = handles the exception if something goes wrong
    // throw e = sends the exception to the controller

    public List<Student> getStudent() {
        try {
            logger.info("Getting all students from database...");
            List<Student> students = studentRepository.findAll();
            logger.info("Students retrieved successfully: {}", students.size());
            return students;
        }

        catch (Exception e) {
            logger.error("Error retrieving students: {}", e.getMessage());
            throw e;
        }
    }

    public Student createStudent(String name, int age, String major) {
        try {
            logger.info("Creating student: " + name);
            List<Student> students = studentRepository.findAll();

            int maxId = 0;

            for (Student student : students) {
                if (student.getId() > maxId) {
                    maxId = student.getId();
                }

            }
            int newId = maxId + 1;

            Student student = new Student(
                    newId,
                    name,
                    age,
                    major,
                    new ArrayList<>()
            );

            studentRepository.save(student);
            logger.info("Student created successfully with ID: " + newId);
            return student;
        }
        catch (Exception e) {
            logger.error("Error creating student: {}", e.getMessage());
            throw e;
        }
    }

    public boolean addCourse(int studentId, String courseId){
        try {
            logger.info("Adding course {} to student {}", courseId, studentId);
            Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                student.getCourseIds().add(courseId);

                studentRepository.save(student);

                logger.info("Course {} added successfully to student {}", courseId, studentId);
                return true;
            }

            logger.warn("Student not found: {}", + studentId);
            return false;

        }
        catch (Exception e) {
           logger.error("Error Updating Student: {}", e.getMessage());
            throw e;
        }

    }

    public boolean deleteStudent(int studentId) {
        try {
            logger.info("Deleting student: {}", studentId);
            Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();

                studentRepository.delete(student);

                logger.info("Student {} deleted successfully", studentId);
                return true;
            }

            logger.warn("Student not found: {}", studentId);
            return false;
        }
        catch (Exception e) {
            logger.error("Error Deleting Student: {}", e.getMessage());
            throw e;
        }
    }

}
