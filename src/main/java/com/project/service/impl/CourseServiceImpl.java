package com.project.service.impl;

import com.project.entity.College;
import com.project.entity.Course;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.CourseDto;
import com.project.repository.CollegeRepo;
import com.project.repository.CourseRepo;
import com.project.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CollegeRepo collegeRepo;

    @Override
    public CourseDto createInCollege(int courseId, int collegeId) {

        College college = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("College ", collegeId + ""));
        Course course_ = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course ", courseId + ""));
        course_.getColleges().add(college);
        college.getCourses().add(course_);
        Course save = this.courseRepo.save(course_);
        return this.mapper.map(save, CourseDto.class);
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        Course map = this.mapper.map(courseDto, Course.class);
        Course save = this.courseRepo.save(map);
        return this.mapper.map(save, CourseDto.class);
    }

    @Override
    public CourseDto update(int courseId, CourseDto courseDto) {

        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", courseId + ""));
        course.setName(courseDto.getName());
        course.setCourseYear(courseDto.getCourseYear());
        Course updated = this.courseRepo.save(course);
        return this.mapper.map(updated, CourseDto.class);
    }

    @Override
    public void deleteCourse(int courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", courseId + ""));
        this.courseRepo.delete(course);
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> all = this.courseRepo.findAll();
        List<CourseDto> collect = all.stream().map((course -> this.mapper.map(course, CourseDto.class))).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CourseDto getCourseById(int courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", courseId + ""));
        return this.mapper.map(course, CourseDto.class);
    }

    @Override
    public List<CourseDto> getByCollege(int collegeId) {
        College college = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("College", collegeId + ""));
        Set<Course> courses = college.getCourses();

        List<CourseDto> collect = courses.stream().map(c -> this.mapper.map(c, CourseDto.class)).collect(Collectors.toList());

        return collect;
    }
}
