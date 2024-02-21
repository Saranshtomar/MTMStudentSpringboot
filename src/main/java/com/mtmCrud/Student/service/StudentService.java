package com.mtmCrud.Student.service;

import com.mtmCrud.Student.model.Student;
import com.mtmCrud.Student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;


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
}
