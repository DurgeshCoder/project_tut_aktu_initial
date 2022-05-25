package com.project.service;

import com.project.payload.CourseDto;

import java.util.List;

public interface CourseService {

    //create
    CourseDto create(CourseDto courseDto);

    //update
    CourseDto update(int courseId, CourseDto courseDto);

    //delete
    void deleteCourse(int courseId);

    List<CourseDto> getCourses();

    CourseDto getCourseByDto(int courseId);


}
