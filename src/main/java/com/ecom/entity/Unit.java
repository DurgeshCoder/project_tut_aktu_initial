package com.ecom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String title;

    private long views;

    @ManyToOne
    private  Subject subject;

    @OneToMany
    private List<Topic> topics=new ArrayList<>();
}
