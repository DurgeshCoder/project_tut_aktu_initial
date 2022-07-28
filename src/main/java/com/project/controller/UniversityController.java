package com.project.controller;

import com.project.entity.University;
import com.project.payload.ApiResponse;
import com.project.payload.UniversityDto;
import com.project.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universities")
public class UniversityController {

    @Autowired
    private UniversityService service;
//     create

    @PostMapping
    public ResponseEntity<UniversityDto> save(@RequestBody UniversityDto dto
    ) {
        UniversityDto university = this.service.createUniversity(dto);
        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }

//    update

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDto> update(@RequestBody UniversityDto dto, @PathVariable int id
    ) {
        UniversityDto university = this.service.updateUniversity(id, dto);
        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }

    //    delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int id
    ) {
        this.service.deleteUniversity(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("University is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


//    get

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDto> get(@PathVariable int id
    ) {
        UniversityDto university = this.service.getUniversityById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }


//    get all

    @GetMapping
    public ResponseEntity<List<UniversityDto>> get() {
        List<UniversityDto> all = this.service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}



