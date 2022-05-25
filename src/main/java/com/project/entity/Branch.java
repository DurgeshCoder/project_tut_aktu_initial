package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String branchCode;

    private String name;

    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(mappedBy = "branches")
    @JsonIgnore
    private Set<Subject> subjects = new HashSet<>();

}
