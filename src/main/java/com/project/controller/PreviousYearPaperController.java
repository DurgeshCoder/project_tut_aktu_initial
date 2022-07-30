package com.project.controller;

import com.project.entity.PreviousPaper;
import com.project.payload.ApiResponse;
import com.project.payload.PreviousPaperDto;
import com.project.service.PreviousPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PreviousYearPaperController {

    private PreviousPaperService previousPaperService;

    @Autowired
    public PreviousYearPaperController(PreviousPaperService previousPaperService) {
        this.previousPaperService = previousPaperService;
    }

    @PostMapping("/subjects/{subjectId}/previous-year-papers")
    public ResponseEntity<PreviousPaperDto> create(
            @RequestBody PreviousPaperDto dto,
            @PathVariable int subjectId
    ) {

        PreviousPaperDto dto1 = this.previousPaperService.create(dto, subjectId);
        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }

    //update

    public ResponseEntity<PreviousPaperDto> update(
            @RequestBody PreviousPaperDto dto1,
            @PathVariable int paperId
    ) {
        PreviousPaperDto dto = this.previousPaperService.update(dto1, paperId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/previous-year-paper/{paperId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int paperId) {
        this.previousPaperService.delete(paperId);
        return new ResponseEntity<>(ApiResponse.getDefaultDeleteInstance("Previous"), HttpStatus.OK);
    }

    //get
    @GetMapping("/previous-year-paper/{paperId}")
    public ResponseEntity<PreviousPaperDto> get(@PathVariable int paperId) {
        PreviousPaperDto dto = this.previousPaperService.get(paperId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/subjects/{subjectId}/previous-year-papers")
    public ResponseEntity<List<PreviousPaperDto>> getBySubject(@PathVariable int subjectId) {
        List<PreviousPaperDto> list = this.previousPaperService.getBySubject(subjectId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
