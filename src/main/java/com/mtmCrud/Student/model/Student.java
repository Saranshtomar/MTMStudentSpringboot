package com.mtmCrud.Student.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;
    @Column(name = "name")
    String name;

    @Column(name = "dob")
    String dob;

    @Column(name = "city")
    String city;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course")
    Set<Course> course = new HashSet<>();
}
