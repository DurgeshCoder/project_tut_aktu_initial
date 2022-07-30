package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private  String totalPages;
    private  String coverUrl;
    private  String downloadCount;
    private  String viewCount;
    @ManyToOne
    private  Subject subject;




}
