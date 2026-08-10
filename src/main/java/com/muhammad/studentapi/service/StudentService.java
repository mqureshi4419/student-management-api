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

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student createStudent(String name, int age, String major) {
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

    public boolean addCourse(int studentId, String courseId){
        Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.getCourseIds().add(courseId);

            studentRepository.save(student);

            return true;
        }

        return false;
    }

    public boolean deleteStudent(int studentId) {
        Optional<Student> studentOptional = studentRepository.findStudentById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            studentRepository.delete(student);

            return true;
        }

        return false;
    }

}
