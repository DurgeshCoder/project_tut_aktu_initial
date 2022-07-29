package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.UnitDto;
import com.project.service.UnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UnitController {

    private UnitService unitService;
    private ModelMapper mapper;

    @Autowired
    public UnitController(UnitService unitService, ModelMapper mapper) {
        this.unitService = unitService;
        this.mapper = mapper;
    }

    //create
    @PostMapping("/subjects/{subjectId}/units")
    public ResponseEntity<UnitDto> create(@RequestBody UnitDto dto, @PathVariable int subjectId) {
        UnitDto unitDto = this.unitService.create(dto, subjectId);
        return ResponseEntity.status(HttpStatus.CREATED).body(unitDto);
    }

    //update

    @PutMapping("/units/{unitId}")
    public ResponseEntity<UnitDto> update(@RequestBody UnitDto unitDto1, @PathVariable int unitId) {
        UnitDto unitDto = this.unitService.update(unitId, unitDto1);
        return ResponseEntity.status(HttpStatus.OK).body(unitDto);
    }


    //delete

    @DeleteMapping("/units/{unitId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int unitId) {
        this.unitService.delete(unitId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Unit is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    //get
    @GetMapping("/units/{unitId}")
    public ResponseEntity<UnitDto> get(@PathVariable int unitId) {
        UnitDto unitDto = this.unitService.get(unitId);
        return ResponseEntity.status(HttpStatus.OK).body(unitDto);
    }

    //get
    @GetMapping("/subjects/{subjectId}/units/")
    public ResponseEntity<List<UnitDto>> getUnitsOfSubjects(@PathVariable int subjectId) {
        List<UnitDto> unitsOfSubjects = this.unitService.getUnitsOfSubjects(subjectId);
        return ResponseEntity.status(HttpStatus.OK).body(unitsOfSubjects);
    }

}
