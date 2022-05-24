package com.ecom.service;


import com.ecom.payload.UniversityDto;

public interface UniversityService {
    //create
    public UniversityDto createUniversity(UniversityDto unisersityDto);

    //update
    public UniversityDto updateUniversity(int userId, UniversityDto unisersityDto);

    //delete
    public void deleteUniversity(int userId);

    //get user

    public UniversityDto getUniversityById(int userId);

}
