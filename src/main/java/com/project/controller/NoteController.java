package com.project.controller;

import com.project.entity.Note;
import com.project.payload.ApiResponse;
import com.project.payload.NoteDto;
import com.project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //create
    @PostMapping("/subjects/{subjectId}/notes")
    public ResponseEntity<NoteDto> create(
            @RequestBody NoteDto dto,
            @PathVariable int subjectId
    ) {
        NoteDto dto1 = this.noteService.create(dto, subjectId);
        return new ResponseEntity<>(dto1, HttpStatus.OK);
    }

    //update
    @PutMapping("/notes/{noteId}")
    public ResponseEntity<NoteDto> update(
            @RequestBody NoteDto dto,
            @PathVariable int noteId
    ) {
        NoteDto dto1 = this.noteService.update(dto, noteId);
        return new ResponseEntity<>(dto1, HttpStatus.OK);
    }


    //delete

    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable int noteId
    ) {
        this.noteService.delete(noteId);
        return new ResponseEntity<>(ApiResponse.getDefaultDeleteInstance("Note"), HttpStatus.OK);
    }


    //get

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<NoteDto> get(@PathVariable int noteId) {
        NoteDto dto = this.noteService.get(noteId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //get by subject
    @GetMapping("/subjects/{subjectId}/notes")
    public ResponseEntity<List<NoteDto>> getBySubjects(@PathVariable int subjectId) {
        List<NoteDto> list = this.noteService.getBySubjects(subjectId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
