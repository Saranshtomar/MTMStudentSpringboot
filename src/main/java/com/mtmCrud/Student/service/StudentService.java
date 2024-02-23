package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Course;
import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.repository.CourseRepository;
import com.mtmCrud.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public String createStudent(Student student) {
        try {
            studentRepository.save(student);
            return "student created successfully";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getAllStudent() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String assignCourseToStudent(Long studentId, Long courseId) {
        try {
            Optional<Student> student = studentRepository.findById(studentId);
            Optional<Course> course = courseRepository.findById(courseId);
            if (student.isPresent() && course.isPresent()) {
                Student existStudent = student.get();
                Set<Course> courseSet = existStudent.getCourse();
                courseSet.add(course.get());
                existStudent.setCourse(courseSet);
                studentRepository.save(existStudent);
                return "Course assigned to Student successfully";
            } else {
                return "Either Student or Course does not exist";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student getStudentById(Long studentId) {
        try {
            Optional<Student> student = studentRepository.findById(studentId);
            return student.orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteStudentById(Long studentId) {
        try {
            Optional<Student> student = studentRepository.findById(studentId);
            if (student.isPresent()) {
                studentRepository.deleteById(studentId);
                return "Student deleted successfully";
            } else {
                return "Student does not exist";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String updateStudentById(Student student, long studentId) {
        Student studentExist = studentRepository.findById(studentId).
                orElseThrow(() -> new RuntimeException("Student Not Found"));
        studentExist.setName(student.getName());
        studentExist.setDob(student.getDob());
        studentExist.setCity(student.getCity());
        studentRepository.save(studentExist);

        return "student Updated Successfully";
    }

    public String removeCourseFromStudent(Long studentId, Long courseId) {
        Optional<Student> studentExist = studentRepository.findById(studentId);
        Optional<Course> courseExist = courseRepository.findById(courseId);
        if (studentExist.isPresent() && courseExist.isPresent()) {
            Set<Course> courseSet = studentExist.get().getCourse();
            courseSet.remove(courseExist.get());
            studentRepository.save(studentExist.get());
            return "Course Remove from student: " + studentId;
        } else return "Either Student or Course Does not Exist";
    }
}
