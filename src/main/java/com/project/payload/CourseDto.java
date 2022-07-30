package com.project.payload;

import com.project.entity.Branch;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CourseDto {
    private int id;
    private String name;
    private int courseYear;
    private Set<BranchDto> branches = new HashSet<>();

}
