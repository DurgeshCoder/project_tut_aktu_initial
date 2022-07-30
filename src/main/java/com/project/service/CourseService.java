package com.project.service;

import com.project.payload.CourseDto;

import java.util.List;

public interface CourseService {


    //create

    CourseDto createInCollege(int courseId,int collegeId);

    CourseDto create(CourseDto courseDto);

    //update
    CourseDto update(int courseId, CourseDto courseDto);

    //delete
    void deleteCourse(int courseId);

    List<CourseDto> getCourses();


    CourseDto getCourseById(int courseId);

    List<CourseDto> getByCollege(int collegeId);

}
