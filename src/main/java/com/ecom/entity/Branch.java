package com.ecom.entity;

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
    private Set<Subject> subjects = new HashSet<>();

}
