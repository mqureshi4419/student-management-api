package com.muhammad.studentapi.service;
import com.muhammad.studentapi.model.Student;
import com.muhammad.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // try = runs code that may cause an exception
    // catch = handles the exception if something goes wrong
    // throw e = sends the exception to the controller

    public List<Student> getStudent() {
        try {
            return studentRepository.findAll();
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Student createStudent(String name, int age, String major) {
        try {
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

            return student;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean addCourse(int studentId, String courseId){
        try {
            Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                student.getCourseIds().add(courseId);

                studentRepository.save(student);

                return true;
            }

            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public boolean deleteStudent(int studentId) {
        try {
            Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();

                studentRepository.delete(student);

                return true;
            }

            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
