package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.repository.CourseRepo;
import com.mtmCrud.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

    public String createStudent(Student student) {
        try {
            studentRepo.save(student);
            return "student created successfully";
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getAllStudent() {
        try{
            return studentRepo.findAll();
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String assignCourseToStudent(Long studentId, Long courseId) {
        try{
            Optional<Student> student = studentRepo.findById(studentId);
            Optional<Course> course =courseRepo.findById(courseId);
            if(student.isPresent() && course.isPresent()){
                Student existStudent = student.get();
                Set<Course> courseSet = existStudent.getCourse();
                courseSet.add(course.get());
                existStudent.setCourse(courseSet);
                studentRepo.save(existStudent);
                return "Course assigned to Student successfully";
            }
            else{
                return "Either Student or Course does not exist";
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
