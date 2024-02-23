package com.mtmCrud.Student.controller;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(){
        return new ResponseEntity<>(courseService.getAllCourse(),HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId){
        Course course = courseService.getCourseById(courseId);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long courseId){
        return new ResponseEntity<>(courseService.deleteCourseById(courseId), HttpStatus.OK);
    }
}
