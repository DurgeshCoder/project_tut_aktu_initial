package com.project.service;

import com.project.payload.PreviousPaperDto;

import java.util.List;

public interface PreviousPaperService {


    PreviousPaperDto create(PreviousPaperDto dto, int subjectId);

    PreviousPaperDto update(PreviousPaperDto dto1, int paperId);

    void delete(int paperId);

    PreviousPaperDto get(int paperId);

    List<PreviousPaperDto> getBySubject(int subjectId);
}
