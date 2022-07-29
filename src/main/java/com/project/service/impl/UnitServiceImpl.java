package com.project.service.impl;

import com.project.entity.Subject;
import com.project.entity.Unit;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.UnitDto;
import com.project.repository.SubjectRepo;
import com.project.repository.UnitRepo;
import com.project.service.UnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService {


    private final SubjectRepo subjectRepo;
    private final UnitRepo unitRepo;
    private final ModelMapper mapper;

    @Autowired
    public UnitServiceImpl(SubjectRepo subjectRepo, UnitRepo unitRepo, ModelMapper mapper) {
        this.subjectRepo = subjectRepo;
        this.unitRepo = unitRepo;
        this.mapper = mapper;
    }

    @Override
    public UnitDto create(UnitDto unitDto, int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject", subjectId + ""));
        Unit unit = this.mapper.map(unitDto, Unit.class);
        unit.setSubject(subject);
        Unit save = this.unitRepo.save(unit);
        return this.mapper.map(save, UnitDto.class);
    }

    @Override
    public UnitDto update(int unitId, UnitDto unitDto) {
        Unit unit = this.unitRepo.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Unit ", unitId + ""));
        Unit unit1 = this.mapper.map(unitDto, Unit.class);
        unit.setTitle(unit1.getTitle());
        unit.setViews(unit1.getViews());
        Unit save = this.unitRepo.save(unit);
        return this.mapper.map(save, UnitDto.class);
    }

    @Override
    public void delete(int unitId) {
        Unit unit = this.unitRepo.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Unit ", unitId + ""));
        this.unitRepo.delete(unit);
    }

    @Override
    public List<UnitDto> getUnitsOfSubjects(int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject", subjectId + ""));
        List<Unit> subjects = this.unitRepo.findBySubject(subject);
        List<UnitDto> collect = subjects.stream().map(unit -> this.mapper.map(unit, UnitDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public UnitDto get(int unitId) {
        Unit unit = this.unitRepo.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Unit ", unitId + ""));
        return this.mapper.map(unit,UnitDto.class);
    }
}
