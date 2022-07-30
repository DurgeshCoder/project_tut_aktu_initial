package com.project.repository;

import com.project.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findBySubject(int subjectId);

}
