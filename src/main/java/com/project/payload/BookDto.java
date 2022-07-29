package com.project.payload;

import com.project.entity.Subject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Setter
@Getter
public class BookDto {

    private int id;
    private  String title;
    private String writer;
    private  String edition;
    private  String pageNumber;
    private  String coverUrl;
    private  String downloadCount;
    private SubjectDto subject;

}
