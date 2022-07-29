package com.project.repository;

import com.project.entity.Subject;
import com.project.entity.Topic;
import com.project.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepo extends JpaRepository<Topic, Integer> {
    List<Topic> findByUnit(Unit unitId);

    List<Topic> findBySubject(Subject subject);

}
