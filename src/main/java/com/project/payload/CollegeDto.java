package com.project.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CollegeDto {

    private int id;
    private String collegeCode;
    private String name;
    private String location;
    private Set<CourseDto>  courses=new HashSet<>();
}
