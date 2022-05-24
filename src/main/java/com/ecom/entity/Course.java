package com.ecom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int courseYear;

    @ManyToMany
    private Set<College> colleges = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    private Set<Branch> branches = new HashSet<>();


}
