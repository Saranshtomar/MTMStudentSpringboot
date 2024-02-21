package com.mtmCrud.Student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.util.collections.LazySet;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id ;
    @Column(name = "name")
    String name;

    @Column(name = "dob")
    String dob;

    @Column(name = "city")
    String city ;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinTable(name = "student_course",
              joinColumns = @JoinColumn(name = "studentId"),
              inverseJoinColumns = @JoinColumn(name = "courseId"))
    Set<Course> course ;
}
