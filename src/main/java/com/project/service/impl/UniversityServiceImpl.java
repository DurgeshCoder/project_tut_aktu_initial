package com.project.service.impl;

import com.project.entity.University;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.UniversityDto;
import com.project.repository.UniversityRepo;
import com.project.service.UniversityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {


    @Autowired
    private UniversityRepo universityRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UniversityDto createUniversity(UniversityDto unisersityDto) {
        University map = this.mapper.map(unisersityDto, University.class);
        University save = this.universityRepo.save(map);
        return this.mapper.map(save, UniversityDto.class);
    }

    @Override
    public UniversityDto updateUniversity(int universityId, UniversityDto unisersityDto) {
        University university = this.universityRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("university ",  universityId + ""));
        university.setName(unisersityDto.getName());
        university.setLocation(unisersityDto.getLocation());
        University updated = this.universityRepo.save(university);
        return this.mapper.map(updated, UniversityDto.class);
    }

    @Override
    public void deleteUniversity(int universityId) {
        University university = this.universityRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("university ", universityId + ""));
        this.universityRepo.delete(university);
    }

    @Override
    public UniversityDto getUniversityById(int universityId) {
        University university = this.universityRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("university ",  universityId + ""));
        return this.mapper.map(university, UniversityDto.class);
    }

    @Override
    public List<UniversityDto> getAll() {
        List<University> all = this.universityRepo.findAll();
        List<UniversityDto> collect = all.stream().map((u) -> this.mapper.map(u, UniversityDto.class)).collect(Collectors.toList());
        return collect;
    }
}
