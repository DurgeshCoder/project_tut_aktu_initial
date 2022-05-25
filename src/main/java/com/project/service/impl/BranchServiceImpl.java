package com.project.service.impl;

import com.project.entity.Branch;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.BranchDto;
import com.project.repository.BranchRepo;
import com.project.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {


    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BranchDto create(BranchDto branchDto) {
        Branch map = this.mapper.map(branchDto, Branch.class);
        Branch save = this.branchRepo.save(map);
        return this.mapper.map(save, BranchDto.class);
    }

    @Override
    public BranchDto update(int branchId, BranchDto branchDto) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", "branchid", branchId + ""));

        return null;
    }

    @Override
    public void delete(int branchId) {

    }

    @Override
    public List<BranchDto> getBranches() {
        return null;
    }

    @Override
    public BranchDto getById(int courseId) {
        return null;
    }
}
