package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public String createCourse(Course course) {
        try{
            courseRepo.save(course);
            return "Course created successfully";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Course> getAllCourse(){
        try{
            return courseRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
