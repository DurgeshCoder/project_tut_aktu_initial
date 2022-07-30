package com.project.controller;

import com.project.entity.College;
import com.project.payload.ApiResponse;
import com.project.payload.CollegeDto;
import com.project.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CollegeController {


    @Autowired
    private CollegeService collegeService;


    //    create
    @PostMapping("/colleges")
    public ResponseEntity<CollegeDto> create(@RequestBody CollegeDto dto) {
        CollegeDto college = this.collegeService.createCollege(dto);
        return new ResponseEntity<>(college, HttpStatus.CREATED);
    }

    //    create
    @PostMapping("/universities/{universityId}/colleges")
    public ResponseEntity<CollegeDto> createInUniversity(@RequestBody CollegeDto dto, @PathVariable int universityId) {
        CollegeDto college = this.collegeService.createCollegeInUniversity(dto, universityId);
        return new ResponseEntity<>(college, HttpStatus.CREATED);
    }


//    update

    @PutMapping("/colleges/{collegeId}")
    public ResponseEntity<CollegeDto> create(@RequestBody CollegeDto dto, @PathVariable int collegeId) {
        CollegeDto college = this.collegeService.updateCollege(collegeId, dto);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

//    delete

    @DeleteMapping("/colleges/{collegeId}")
    public ResponseEntity<ApiResponse> update(@PathVariable int collegeId) {
        this.collegeService.deleteCollege(collegeId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("College is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    get

    @GetMapping("/colleges/{collegeId}")
    public ResponseEntity<CollegeDto> get(@PathVariable int collegeId) {
        CollegeDto college = this.collegeService.getCollegeById(collegeId);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }


    //    get all
    @GetMapping("/colleges")
    public ResponseEntity<List<CollegeDto>> getAll() {
        List<CollegeDto> colleges = this.collegeService.getColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    //
    //    get
    @GetMapping("/universities/{universityId}/colleges")
    public ResponseEntity<List<CollegeDto>> getCollegeOfUniversity(@PathVariable int universityId) {
        List<CollegeDto> colleges = this.collegeService.getCollegeOfUniversity(universityId);
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

}



