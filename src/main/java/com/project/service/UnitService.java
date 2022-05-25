package com.project.service;

import com.project.payload.UnitDto;

import java.util.List;

public interface UnitService {

    //create
    UnitDto create(UnitDto unitDto);

    //update
    UnitDto update(int unitId, UnitDto unitDto);

    //delete
    void delete(int unitId);

    //get units of subjects
    List<UnitDto> getUnitsOfSubjects(int subjectId);


}
