package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public Course getCourseById(Long courseId){
        try{
            Optional<Course> course = courseRepo.findById(courseId);
            if(course.isPresent()){
                return course.get();
            }
            else{
                return null;
            }
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
