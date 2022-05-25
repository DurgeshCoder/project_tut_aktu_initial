package com.project.service;


import com.project.payload.UniversityDto;

public interface UniversityService {
    //create
    public UniversityDto createUniversity(UniversityDto unisersityDto);

    //update
    public UniversityDto updateUniversity(int universityId, UniversityDto unisersityDto);

    //delete
    public void deleteUniversity(int universityId);

    //get user

    public UniversityDto getUniversityById(int userId);

}
