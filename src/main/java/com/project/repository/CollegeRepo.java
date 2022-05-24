package com.project.repository;

import com.project.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Integer> {
}
