package com.mtmCrud.Student.controller;

import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    //creating a student
    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    //Getting all the student
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    //Getting student by id
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    //adding course for a student.
    @PutMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<String> assignCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(studentService.assignCourseToStudent(studentId, courseId), HttpStatus.OK);
    }

    //removing course from a student.
    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<String> removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(studentService.removeCourseFromStudent(studentId, courseId), HttpStatus.OK);
    }

    // Deleting student by id.
    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.deleteStudentById(studentId), HttpStatus.OK);
    }

    //updating student by id.
    @PutMapping("/student/{studentId}")
    public ResponseEntity<String> updateStudentById(@RequestBody Student student, @PathVariable long studentId) {
        return new ResponseEntity<>(studentService.updateStudentById(student, studentId), HttpStatus.OK);
    }

}
