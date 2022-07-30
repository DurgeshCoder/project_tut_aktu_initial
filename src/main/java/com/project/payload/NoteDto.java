package com.project.payload;

import com.project.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
public class NoteDto {

    private int id;
    private String title;
    private String downloadLink;
    private String viewCount;
    private String totalViews;
    private SubjectDto subject;
}
