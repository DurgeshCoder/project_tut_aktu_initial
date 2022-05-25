package com.project.controller;


import com.project.payload.CourseDto;
import com.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {


    @Autowired
    private CourseService courseService;
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> courses = this.courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
