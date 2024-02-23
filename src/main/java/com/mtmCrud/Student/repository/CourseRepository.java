package com.mtmCrud.Student.repository;

import com.mtmCrud.Student.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
