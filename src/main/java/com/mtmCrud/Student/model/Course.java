package com.mtmCrud.Student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    Set<Student> student = new HashSet<>();

}
