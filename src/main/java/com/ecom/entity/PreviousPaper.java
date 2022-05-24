package com.ecom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PreviousPaper {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int year;

    private int semester;
    private String questionPaperUrl;

    private String answerUrl;

    @ManyToOne
    private Subject subject;

}
