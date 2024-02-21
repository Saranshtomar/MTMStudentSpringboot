package com.mtmCrud.Student.controller;

import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        return  new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>>  getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }

}
