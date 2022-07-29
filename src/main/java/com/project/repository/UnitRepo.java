package com.project.repository;

import com.project.entity.Subject;
import com.project.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepo extends JpaRepository<Unit,Integer> {
    List<Unit> findBySubject(Subject subject);
}
