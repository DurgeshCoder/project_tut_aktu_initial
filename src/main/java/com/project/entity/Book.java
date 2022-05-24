package com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String title;
    private String writer;
    private  String edition;
    private  String pageNumber;
    private  String coverUrl;
    private  String downloadCount;
    @ManyToOne
    private  Subject subject;




}
