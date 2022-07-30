package com.project.service;

import com.project.payload.NoteDto;

import java.util.List;

public interface NoteService {
    NoteDto create(NoteDto dto, int subjectId);

    NoteDto update(NoteDto dto, int noteId);

    void delete(int noteId);

    NoteDto get(int noteId);

    List<NoteDto> getBySubjects(int subjectId);

}
