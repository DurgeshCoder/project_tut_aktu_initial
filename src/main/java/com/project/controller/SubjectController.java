package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.SubjectDto;
import com.project.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SubjectController {

    private SubjectService subjectService;
    private ModelMapper mapper;

    public SubjectController(SubjectService subjectService, ModelMapper mapper) {
        this.subjectService = subjectService;
        this.mapper = mapper;
    }


    //create
    @PostMapping("/subjects")
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto dto) {
        SubjectDto subjectDto = this.subjectService.create(dto);
        return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
    }

    //create
    @PostMapping("/branches/{branchId}/subjects/{subjectId}")
    public ResponseEntity<SubjectDto> MapSubjectToBranch(@PathVariable int subjectId, @PathVariable int branchId) {
        SubjectDto subjectDto = this.subjectService.create(subjectId, branchId);
        return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/subjects/{subjectId}")
    public ResponseEntity<SubjectDto> update(@RequestBody SubjectDto dto, @PathVariable int subjectId) {
        SubjectDto subjectDto = this.subjectService.update(subjectId, dto);
        return new ResponseEntity<>(subjectDto, HttpStatus.OK);
    }


    //delete
    @DeleteMapping("/subjects/{subjectId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int subjectId) {
        this.subjectService.delete(subjectId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Subject is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //get

    @GetMapping("/subjects/{subjectId}")
    public ResponseEntity<SubjectDto> get(@PathVariable int subjectId) {
        SubjectDto subjectDto = this.subjectService.getById(subjectId);
        return new ResponseEntity<>(subjectDto, HttpStatus.OK);
    }

    @GetMapping("/branches/{branchId}/subjects")
    public ResponseEntity<List<SubjectDto>> getByBranch(@PathVariable int branchId) {
        List<SubjectDto> subjectsOfBranch = this.subjectService.getSubjectsOfBranch(branchId);
        return new ResponseEntity<>(subjectsOfBranch, HttpStatus.OK);
    }


}
