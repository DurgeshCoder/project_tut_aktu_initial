package com.project.service.impl;

import com.project.entity.Note;
import com.project.entity.Subject;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.NoteDto;
import com.project.repository.NoteRepo;
import com.project.repository.SubjectRepo;
import com.project.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.RefreshFailedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {


    private SubjectRepo subjectRepo;
    private NoteRepo noteRepo;
    private ModelMapper mapper;

    @Autowired
    public NoteServiceImpl(SubjectRepo subjectRepo, NoteRepo noteRepo, ModelMapper mapper) {
        this.subjectRepo = subjectRepo;
        this.noteRepo = noteRepo;
        this.mapper = mapper;
    }

    @Override
    public NoteDto create(NoteDto dto, int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        Note map = this.mapper.map(dto, Note.class);
        map.setSubject(subject);
        Note save = this.noteRepo.save(map);
        return this.mapper.map(save, NoteDto.class);
    }

    @Override
    public NoteDto update(NoteDto dto, int noteId) {
        Note note = this.noteRepo.findById(noteId).orElseThrow(ResourceNotFoundException::new);
        note.setDownloadLink(dto.getDownloadLink());
        note.setTitle(dto.getTitle());
        note.setViewCount(dto.getViewCount());
        note.setTotalViews(dto.getTotalViews());
        Note save = this.noteRepo.save(note);
        return this.mapper.map(save, NoteDto.class);
    }

    @Override
    public void delete(int noteId) {
        Note note = this.noteRepo.findById(noteId).orElseThrow(ResourceNotFoundException::new);
        this.noteRepo.delete(note);
    }

    @Override
    public NoteDto get(int noteId) {
        Note note = this.noteRepo.findById(noteId).orElseThrow(ResourceNotFoundException::new);
        return this.mapper.map(note, NoteDto.class);
    }

    @Override
    public List<NoteDto> getBySubjects(int subjectId) {
        List<Note> list = this.noteRepo.findBySubject(subjectId);
        return list.stream()
                .map(note -> this.mapper.map(note, NoteDto.class))
                .collect(Collectors.toList());
    }
}
