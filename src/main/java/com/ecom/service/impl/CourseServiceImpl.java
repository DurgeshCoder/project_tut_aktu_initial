package com.ecom.service.impl;

import com.ecom.entity.Course;
import com.ecom.payload.CourseDto;
import com.ecom.repository.CourseRepo;
import com.ecom.service.CourseService;
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
