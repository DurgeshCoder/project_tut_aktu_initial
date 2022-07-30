package com.project.repository;

import com.project.entity.College;
import com.project.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepo extends JpaRepository<College,Integer> {
    List<College> findByUniversity(University university);
}
