package com.project.service;

import com.project.payload.SubjectDto;

import java.util.List;

public interface SubjectService {


    //create
    SubjectDto create(int subject, int branchId);

    SubjectDto create(SubjectDto subjectDto);

    //update
    SubjectDto update(int subjectId, SubjectDto subjectDto);

    //delete
    void delete(int subjectId);

    //get
    SubjectDto getById(int subjectId);

    List<SubjectDto> getSubjects();


    List<SubjectDto> getSubjectsOfBranch(int branchId);
}
