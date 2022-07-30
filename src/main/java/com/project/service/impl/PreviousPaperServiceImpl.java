package com.project.service.impl;

import com.project.entity.PreviousPaper;
import com.project.entity.Subject;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.PreviousPaperDto;
import com.project.repository.PreviousPaperRepo;
import com.project.repository.SubjectRepo;
import com.project.service.PreviousPaperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviousPaperServiceImpl implements PreviousPaperService {


    private PreviousPaperRepo previousPaperRepo;
    private SubjectRepo subjectRepo;
    private ModelMapper mapper;

    public PreviousPaperServiceImpl(PreviousPaperRepo previousPaperRepo, SubjectRepo subjectRepo, ModelMapper mapper) {
        this.previousPaperRepo = previousPaperRepo;
        this.subjectRepo = subjectRepo;
        this.mapper = mapper;
    }

    @Override
    public PreviousPaperDto create(PreviousPaperDto dto, int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        PreviousPaper paper = this.mapper.map(dto, PreviousPaper.class);
        paper.setSubject(subject);
        PreviousPaper save = this.previousPaperRepo.save(paper);
        return this.mapper.map(save, PreviousPaperDto.class);
    }

    @Override
    public PreviousPaperDto update(PreviousPaperDto dto1, int paperId) {
        PreviousPaper previousPaper = this.previousPaperRepo.findById(paperId).orElseThrow(ResourceNotFoundException::new);
        previousPaper.setQuestionPaperUrl(dto1.getQuestionPaperUrl());
        previousPaper.setAnswerUrl(dto1.getAnswerUrl());
        previousPaper.setTitle(dto1.getTitle());
        previousPaper.setSemester(dto1.getSemester());
        previousPaper.setYear(dto1.getYear());
        PreviousPaper save = this.previousPaperRepo.save(previousPaper);
        return this.mapper.map(save, PreviousPaperDto.class);
    }

    @Override
    public void delete(int paperId) {
        PreviousPaper previousPaper = this.previousPaperRepo.findById(paperId).orElseThrow(ResourceNotFoundException::new);
        this.previousPaperRepo.delete(previousPaper);
    }

    @Override
    public PreviousPaperDto get(int paperId) {
        PreviousPaper previousPaper = this.previousPaperRepo.findById(paperId).orElseThrow(ResourceNotFoundException::new);
        return this.mapper.map(previousPaper, PreviousPaperDto.class);
    }

    @Override
    public List<PreviousPaperDto> getBySubject(int subjectId) {
        List<PreviousPaper> list = this.previousPaperRepo.findBySubject(subjectId);
        return list.stream()
                .map(previousPaper -> this.mapper.map(previousPaper, PreviousPaperDto.class))
                .collect(Collectors.toList());
    }
}
