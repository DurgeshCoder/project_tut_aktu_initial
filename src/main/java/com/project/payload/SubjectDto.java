package com.project.payload;

import com.project.entity.Unit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SubjectDto {
    private int id;

    private String subjectName;

    private String subjectCode;

    private int year;

    private int semester;

    private String about;

}
