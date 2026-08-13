package com.muhammad.studentapi.controller;
import com.muhammad.studentapi.service.StudentService;
import com.muhammad.studentapi.model.ApiError;

import com.muhammad.studentapi.model.Student;
import org.springframework.http.ResponseEntity;
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

    // ResponseEntity controls the HTTP response sent to the client
    // 200 OK = request successful
    // 404 Not Found = requested student does not exist
    // 500 Internal Server Error = unexpected server/database error

    @GetMapping("/getstudent")
    public ResponseEntity<?> getStudent() {
        try {
            return ResponseEntity.ok(studentService.getStudent()); // successful response (200 OK)
        }
        catch (Exception e){
            ApiError error = new ApiError(
                    500,
                    "Internal Server Error",
                    "Database connection failed"
            );
            return ResponseEntity.internalServerError().body(error); // return 500 Internal Server Error
        }
    }

    @PostMapping("/createstudent")
    public ResponseEntity<?> createStudent(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String major) {

        try {
            return ResponseEntity.ok(studentService.createStudent(name, age, major));
        }
        catch (Exception e){
            ApiError error = new ApiError(
                    500,
                    "Internal Server Error",
                    "Unable to create student due to a backend error"
            );
            return ResponseEntity.internalServerError().body(error); // return 500 Internal Server Error
        }
    }

    @PutMapping("/updatestudent")
    public ResponseEntity<?> putStudent(
            @RequestParam int studentId,
            @RequestParam String courseId) {

        try {
            boolean updated = studentService.addCourse(studentId, courseId);
            if (updated) {
                return ResponseEntity.ok(true);
            }
            ApiError error = new ApiError(
                    404,
                    "Not Found",
                    "Student not found"
            );
            return ResponseEntity.status(404).body(error);
        }
        catch (Exception e){
            ApiError error = new ApiError(
                    500,
                    "Internal Server Error",
                    "Unable to update student due to a backend error"
            );
            return ResponseEntity.internalServerError().body(error); // return 500 Internal Server Error
        }
    }

    @DeleteMapping("/deletestudent")
    public ResponseEntity<?> deleteStudent(
            @RequestParam int studentId){

        try {
            boolean deleted = studentService.deleteStudent(studentId);
            if(deleted) {
                return ResponseEntity.ok(true);
            }
            ApiError error = new ApiError(
                    404,
                    "Not Found",
                    "Student not found"
            );
            return ResponseEntity.status(404).body(error);
        }
        catch (Exception e) {
            ApiError error = new ApiError(
                    500,
                    "Internal Server Error",
                    "Unable to delete student due to a backend error"
            );
            return ResponseEntity.internalServerError().body(error); // return 500 Internal Server Error
        }
    }

}
