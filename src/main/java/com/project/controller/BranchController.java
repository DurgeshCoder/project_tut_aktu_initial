package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.BranchDto;
import com.project.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class BranchController {


    private BranchService branchService;
    private ModelMapper mapper;

    @Autowired
    public BranchController(BranchService branchService, ModelMapper mapper) {
        this.branchService = branchService;
        this.mapper = mapper;
    }
    //create

    @PostMapping("/branches")
    public ResponseEntity<BranchDto> create(@RequestBody BranchDto branchDto) {
        BranchDto inCourse = this.branchService.create(branchDto);
        return new ResponseEntity<>(inCourse, HttpStatus.CREATED);
    }

    @PostMapping("/courses/{courseId}/branches/{branchId}")
    public ResponseEntity<BranchDto> createInCourse(@PathVariable int courseId,@PathVariable int branchId) {
        BranchDto inCourse = this.branchService.createInCourse(branchId, courseId);
        return new ResponseEntity<>(inCourse, HttpStatus.CREATED);
    }

    //update
    @PutMapping("//branches/{branchId}")
    public ResponseEntity<BranchDto> update(@RequestBody BranchDto branchDto, @PathVariable int branchId) {
        BranchDto inCourse = this.branchService.update(branchId, branchDto);
        return new ResponseEntity<>(inCourse, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/branches/{branchId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int branchId) {
        this.branchService.delete(branchId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Branch is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //getbranch
    @GetMapping("/branches/{branchId}")
    public ResponseEntity<BranchDto> getById(@PathVariable int branchId) {
        BranchDto branchDto = this.branchService.getById(branchId);
        return new ResponseEntity<>(branchDto, HttpStatus.OK);
    }

    //getbranch
    @GetMapping("courses/{courseId}/branches")
    public ResponseEntity<List<BranchDto>> getByCourse(@PathVariable int courseId) {
        List<BranchDto> byCourse = this.branchService.getByCourse(courseId);
        return new ResponseEntity<>(byCourse, HttpStatus.OK);
    }

    //getbranches
    @GetMapping("/branches")
    public ResponseEntity<List<BranchDto>> getAll() {
        List<BranchDto> byCourse = this.branchService.getBranches();
        return new ResponseEntity<>(byCourse, HttpStatus.OK);
    }


}
