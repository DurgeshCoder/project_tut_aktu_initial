package com.project.service.impl;

import com.project.entity.Branch;
import com.project.entity.Subject;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.SubjectDto;
import com.project.repository.BranchRepo;
import com.project.repository.SubjectRepo;
import com.project.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {


    private SubjectRepo subjectRepo;
    private BranchRepo branchRepo;
    private ModelMapper mapper;

    @Autowired
    public SubjectServiceImpl(SubjectRepo subjectRepo, BranchRepo branchRepo, ModelMapper mapper) {
        this.subjectRepo = subjectRepo;
        this.branchRepo = branchRepo;
        this.mapper = mapper;
    }

    @Override
    public SubjectDto create(int subjectId, int branchId) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch ", branchId + ""));
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow();
        subject.getBranches().add(branch);
        branch.getSubjects().add(subject);
        Subject save = this.subjectRepo.save(subject);
        return this.mapper.map(save, SubjectDto.class);
    }

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        Subject map = this.mapper.map(subjectDto, Subject.class);
        Subject save = this.subjectRepo.save(map);
        return this.mapper.map(save, SubjectDto.class);
    }

    @Override
    public SubjectDto update(int subjectId, SubjectDto subjectDto) {

        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject ", subjectId + ""));
        subject.setSubjectCode(subjectDto.getSubjectCode());
        subject.setAbout(subjectDto.getAbout());
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setSemester(subjectDto.getSemester());
        subject.setYear(subjectDto.getYear());
        Subject save = this.subjectRepo.save(subject);
        return this.mapper.map(save, SubjectDto.class);
    }

    @Override
    public void delete(int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject ", subjectId + ""));
        this.subjectRepo.delete(subject);
    }

    @Override
    public SubjectDto getById(int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject ", subjectId + ""));
        return this.mapper.map(subject, SubjectDto.class);
    }

    @Override
    public List<SubjectDto> getSubjects() {

        List<Subject> all = this.subjectRepo.findAll();
        List<SubjectDto> collect = all.stream().map((s) -> this.mapper.map(s, SubjectDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<SubjectDto> getSubjectsOfBranch(int branchId) {
        Branch branch = this.branchRepo.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch ", branchId + ""));
        Set<Subject> subjects = branch.getSubjects();
        List<SubjectDto> collect = subjects.stream().map((s) -> this.mapper.map(s, SubjectDto.class)).collect(Collectors.toList());
        return collect;
    }
}
