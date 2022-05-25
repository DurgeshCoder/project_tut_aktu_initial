package com.project.service;

import com.project.payload.BranchDto;

import java.util.List;

public interface BranchService {

    //create
    BranchDto create(BranchDto branchDto);

    //update
    BranchDto update(int branchId, BranchDto branchDto);

    //delete
    void delete(int branchId);

    //get
    List<BranchDto> getBranches();


    BranchDto getById(int courseId);
}
