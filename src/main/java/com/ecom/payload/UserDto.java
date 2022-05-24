package com.ecom.payload;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private int userId;
    private String email;
    private String name;
    private String link;
    private String phone;
    private int year;
    private UniversityDto university;
    private CollegeDto college;
    private CourseDto course;
    private BranchDto branch;
}
