package com.ecom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String email;

    private String name;
    private String link;
    @OneToOne
    private University university;

    @OneToOne
    private College college;


    private String phone;

    @OneToOne
    private Course course;

    @OneToOne
    private Branch branch;
    private int year;

}
