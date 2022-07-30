package com.project.service;

import com.project.entity.Branch;
import com.project.payload.BranchDto;

import java.util.List;

public interface BranchService {

    //create
    BranchDto create(BranchDto branchDto);

    BranchDto createInCourse(int branchId,int courseId);

    //update
    BranchDto update(int branchId, BranchDto branchDto);

    //delete
    void delete(int branchId);

    //get
    List<BranchDto> getBranches();


    BranchDto getById(int branchId);

    //get by course

    List<BranchDto> getByCourse(int courseId);
}
