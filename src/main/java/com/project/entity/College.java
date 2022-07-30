package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @Column(unique = true)
    private String collegeCode;
    private String name;
    private String location;
    @ManyToOne
    private University university;
    @ManyToMany(mappedBy = "colleges", fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

}
