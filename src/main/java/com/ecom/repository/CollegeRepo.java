package com.ecom.repository;

import com.ecom.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Integer> {
}
