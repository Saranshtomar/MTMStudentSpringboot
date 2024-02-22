package com.mtmCrud.Student.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    long id;

    @Column(name = "name")
    String name ;

    @Column(name = "duration")
    float duration;

    @ManyToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,mappedBy ="course")
    Set<Student> student = new HashSet<>();

}
