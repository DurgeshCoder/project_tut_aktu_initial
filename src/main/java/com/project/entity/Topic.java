package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 1000000)
    private String content;

    private String pageAuthor;
    private String pageKeywords;
    private String pageDescription;

    @ManyToOne
    private  Unit unit;

    @ManyToOne
    private  Subject subject;
}
