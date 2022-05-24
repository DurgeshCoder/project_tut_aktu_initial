package com.project.service.impl;

import com.project.entity.Course;
import com.project.payload.CourseDto;
import com.project.repository.CourseRepo;
import com.project.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;


    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CourseDto> getCourses() {
        List<Course> all = this.courseRepo.findAll();
        List<CourseDto> collect = all.stream().map((course -> this.mapper.map(course, CourseDto.class))).collect(Collectors.toList());
        return collect;
    }
}
