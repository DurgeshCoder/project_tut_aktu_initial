package com.project.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private int userId;
    private String email;
    private String name;
    private String link;
    private String phone;
    private int year;
    private int universityId;
    private int collegeId;
    private int courseId;
    private int branchId;
    private  int semester;
}
