package com.project;

import antlr.actions.python.CodeLexer;
import com.project.entity.College;
import com.project.entity.Course;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.CourseDto;
import com.project.repository.CollegeRepo;
import com.project.repository.CourseRepo;
import com.project.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class ProjectTutTests {

    @Autowired
    private CourseService courseService;

    @Test
    void contextLoads() {



    }

}
