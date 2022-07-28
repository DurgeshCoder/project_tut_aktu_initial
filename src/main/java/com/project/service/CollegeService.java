package com.project.service;

import com.project.entity.College;
import com.project.payload.CollegeDto;

import java.util.List;

public interface CollegeService {

    //create

    CollegeDto createCollegeInUniversity(CollegeDto dto, int universityId);
    CollegeDto createCollege(CollegeDto collegeDto);
    //update
    CollegeDto updateCollege(int collegeId, CollegeDto collegeDto);
    //delete
    void deleteCollege(int collegeId);
    //get
    List<CollegeDto> getColleges();
    CollegeDto getCollegeById(int collegeId);

    List<CollegeDto> getCollegeOfUniversity(int universityId);
}
