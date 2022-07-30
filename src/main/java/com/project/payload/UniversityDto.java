package com.project.payload;

import com.project.entity.College;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UniversityDto {

    private int id;
    private String name;
    private String location;
    private Set<CollegeDto> colleges = new HashSet<>();

}
