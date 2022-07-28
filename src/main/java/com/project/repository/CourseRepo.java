package com.project.repository;

import com.project.entity.College;
import com.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
