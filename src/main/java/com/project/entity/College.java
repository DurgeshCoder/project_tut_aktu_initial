package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String collegeCode;
    private String name;
    private String location;

    @ManyToOne
    @JsonBackReference
    private University university;

    @ManyToMany(mappedBy = "colleges")
    private Set<Course> courses = new HashSet<>();

}
