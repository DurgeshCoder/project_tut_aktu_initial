package com.project.controller;


import com.project.entity.Course;
import com.project.payload.ApiResponse;
import com.project.payload.CourseDto;
import com.project.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CourseController {


    @Autowired
    private CourseService courseService;

//    create

    @PostMapping("/courses")
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = courseService.create(courseDto);
        return new ResponseEntity<>(courseDto1, HttpStatus.CREATED);

    }

    @PostMapping("/colleges/{collegeId}/courses/{courseId}")
    public ResponseEntity<CourseDto> createInCollege(@PathVariable int collegeId,@PathVariable int courseId) {
        CourseDto courseDto1 = courseService.createInCollege(courseId, collegeId);
        return new ResponseEntity<>(courseDto1, HttpStatus.OK);

    }


//    update


    @PutMapping("/courses/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable int courseId) {
        CourseDto courseDto1 = courseService.update(courseId, courseDto);
        return new ResponseEntity<>(courseDto1, HttpStatus.OK);
    }


//    delete


    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Course is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //    get
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseDto> getById(@PathVariable int courseId) {
        CourseDto courseById = this.courseService.getCourseById(courseId);
        return new ResponseEntity<>(courseById, HttpStatus.OK);
    }

    ;


    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> courses = this.courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @GetMapping("/colleges/{collegeId}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesOfCollege(@PathVariable int collegeId) {
        List<CourseDto> courses = this.courseService.getByCollege(collegeId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }



}
