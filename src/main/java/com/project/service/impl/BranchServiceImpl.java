package com.project.service.impl;

import com.project.entity.Branch;
import com.project.entity.Course;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.BranchDto;
import com.project.repository.BranchRepo;
import com.project.repository.CourseRepo;
import com.project.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {


    private BranchRepo branchRepo;

    private ModelMapper mapper;

    private CourseRepo courseRepo;

    @Autowired
    public BranchServiceImpl(BranchRepo branchRepo, ModelMapper mapper, CourseRepo courseRepo) {
        this.branchRepo = branchRepo;
        this.mapper = mapper;
        this.courseRepo = courseRepo;
    }

    @Override
    public BranchDto create(BranchDto branchDto) {
        Branch map = this.mapper.map(branchDto, Branch.class);
        Branch save = this.branchRepo.save(map);
        return this.mapper.map(save, BranchDto.class);
    }

    @Override
    public BranchDto createInCourse(int branchId, int courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", courseId + ""));
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch ", branchId + ""));
        branch.getCourses().add(course);
        course.getBranches().add(branch);
        Branch save = this.branchRepo.save(branch);
        return this.mapper.map(save, BranchDto.class);
    }

    @Override
    public BranchDto update(int branchId, BranchDto branchDto) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", branchId + ""));
        branch.setBranchCode(branchDto.getBranchCode());
        branch.setName(branchDto.getName());
        Branch save = this.branchRepo.save(branch);
        return this.mapper.map(save, BranchDto.class);
    }

    @Override
    public void delete(int branchId) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", branchId + ""));
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
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch", branchId + ""));
        return this.mapper.map(branch, BranchDto.class);


    }

    @Override
    public List<BranchDto> getByCourse(int courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", courseId + ""));
        Set<Branch> branches = course.getBranches();
        List<BranchDto> collect = branches.stream().map(b -> this.mapper.map(b, BranchDto.class)).collect(Collectors.toList());
        return collect;
    }


}
