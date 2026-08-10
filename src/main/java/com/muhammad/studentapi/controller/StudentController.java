package com.muhammad.studentapi.controller;
import com.muhammad.studentapi.service.StudentService;

import com.muhammad.studentapi.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getstudent")
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping("/createstudent")
    public Student createStudent(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String major) {

        return studentService.createStudent(name, age, major);
    }

    @PutMapping("/updatestudent")
    public boolean putStudent(
            @RequestParam int studentId,
            @RequestParam String courseId) {

        return studentService.addCourse(studentId,courseId);
    }

    @DeleteMapping("/deletestudent")
    public boolean deleteStudent(
            @RequestParam int studentId){

        return studentService.deleteStudent(studentId);
    }

}
