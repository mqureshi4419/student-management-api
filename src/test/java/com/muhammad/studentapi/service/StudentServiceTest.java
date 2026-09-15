package com.muhammad.studentapi.service;

import com.muhammad.studentapi.repository.StudentRepository;
import com.muhammad.studentapi.model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

public class StudentServiceTest {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void createStudentCreatesAndReturnsStudent() {
        Student existingStudent = new Student(
                5,
                "Sara",
                22,
                "Science",
                new java.util.ArrayList<>()
        );

        List<Student> existingStudents = List.of(existingStudent);

        Mockito.when(studentRepository.findAll())
                .thenReturn(existingStudents);

        Student result = studentService.createStudent("John",20, "Computer Science");

        assertEquals(6, result.getId());
        assertEquals("John", result.getName());
        assertEquals(20, result.getAge());
        assertEquals("Computer Science", result.getMajor());

        Mockito.verify(studentRepository, Mockito.times(1))
                .save(result);

    }

    @Test
    void updateStudentDetailsUpdatesExistingStudent() {
        Student existingStudent = new Student(
                5,
                "Sara",
                22,
                "Science",
                new java.util.ArrayList<>()
        );

        Mockito.when(studentRepository.findStudentById(5))
                .thenReturn(java.util.Optional.of(existingStudent));

        Mockito.when(studentRepository.save(existingStudent))
                .thenReturn(existingStudent);

        Student result =
                studentService.updateStudentDetails(
                        5,
                        "Sarah Updated",
                        23,
                        "Computer Science"
                );

        assertEquals(5, result.getId());
        assertEquals("Sarah Updated", result.getName());
        assertEquals(23, result.getAge());
        assertEquals("Computer Science", result.getMajor());

        Mockito.verify(studentRepository, Mockito.times(1))
                .save(existingStudent);

    }

    @Test
    void updateStudentDetailsReturnsNullWhenStudentNotFound() {
        Mockito.when(studentRepository.findStudentById(99))
                .thenReturn(java.util.Optional.empty());

        Student result =
                studentService.updateStudentDetails(
                        99,
                        "Does Not Matter",
                        20,
                        "Anything"
                );

        assertNull(result);

        Mockito.verify(studentRepository, Mockito.never())
                .save(Mockito.any(Student.class));
    }

    @Test
    void deleteStudentReturnsTrueWhenStudentExists() {
        Student existingStudent = new Student(
                5,
                "Sara",
                22,
                "Science",
                new java.util.ArrayList<>()
        );

        Mockito.when(studentRepository.findStudentById(5))
                .thenReturn(java.util.Optional.of(existingStudent));


        boolean result = studentService.deleteStudent(5);
        assertTrue(result);

        Mockito.verify(studentRepository, Mockito.times(1))
                .delete(existingStudent);

    }

    @Test
    void deleteStudentReturnsFalseWhenStudentNotFound() {

        Mockito.when(studentRepository.findStudentById(99))
                .thenReturn(java.util.Optional.empty());

        boolean result = studentService.deleteStudent(99);

        assertFalse(result);

        Mockito.verify(studentRepository, Mockito.never())
                .delete(Mockito.any(Student.class));
    }

    @Test
    void getStudentReturnsAllStudents() {
        Student firstStudent = new Student(
                1,
                "Sara",
                22,
                "Science",
                new java.util.ArrayList<>()
        );

        Student secondStudent = new Student(
                2,
                "John",
                20,
                "Computer Science",
                new java.util.ArrayList<>()
        );

        List<Student> students = List.of(firstStudent, secondStudent);

        Mockito.when(studentRepository.findAll())
                .thenReturn(students);

        List<Student> result = studentService.getStudent();

        assertEquals(2, result.size());
        assertEquals("Sara", result.get(0).getName());
        assertEquals("John", result.get(1).getName());

        Mockito.verify(studentRepository, Mockito.times(1))
                .findAll();

    }

}
