package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public String createCourse(Course course) {
        try{
            courseRepository.save(course);
            return "Course created successfully";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Course getCourseById(Long courseId){
        try{
            Optional<Course> course = courseRepository.findById(courseId);
            return course.orElse(null);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Course> getAllCourse(){
        try{
            return courseRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        for (Student student : course.getStudent()) {
            student.getCourse().remove(course);
        }
        course.getStudent().clear();
        courseRepository.delete(course);
        return "Course deleted successfully";
    }
}
