package com.project.repository;

import com.project.entity.PreviousPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreviousPaperRepo extends JpaRepository<PreviousPaper, Integer> {
    List<PreviousPaper> findBySubject(int subjectId);

}
