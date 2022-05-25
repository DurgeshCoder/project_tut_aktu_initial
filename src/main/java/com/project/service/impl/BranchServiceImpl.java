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
import java.util.stream.Collectors;

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
        branch.setBranchCode(branchDto.getBranchCode());
        branch.setName(branchDto.getName());
        Branch save = this.branchRepo.save(branch);
        return this.mapper.map(save, BranchDto.class);
    }

    @Override
    public void delete(int branchId) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", "branchid", branchId + ""));
        this.branchRepo.delete(branch);
    }

    @Override
    public List<BranchDto> getBranches() {
        List<Branch> all = this.branchRepo.findAll();
        return all
                .stream()
                .map(branch -> this.mapper.map(branch, BranchDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto getById(int branchId) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", "branchid", branchId + ""));
        return this.mapper.map(branch, BranchDto.class);


    }
}
