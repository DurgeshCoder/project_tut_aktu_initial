package com.project.service.impl;

import com.project.entity.College;
import com.project.entity.University;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.CollegeDto;
import com.project.repository.CollegeRepo;
import com.project.repository.UniversityRepo;
import com.project.service.CollegeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UniversityRepo universityRepo;

    @Override
    public CollegeDto createCollegeInUniversity(CollegeDto dto, int universityId) {
        University university = this.universityRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("University ", universityId + ""));

        College college = this.modelMapper.map(dto, College.class);
        college.setUniversity(university);
        university.getColleges().add(college);
        College save = this.collegeRepo.save(college);
        return this.modelMapper.map(save, CollegeDto.class);
    }

    @Override
    public CollegeDto createCollege(CollegeDto collegeDto) {
        College map = this.modelMapper.map(collegeDto, College.class);
        College save = this.collegeRepo.save(map);
        return this.modelMapper.map(save, CollegeDto.class);
    }

    @Override
    public CollegeDto updateCollege(int collegeId, CollegeDto collegeDto) {

        College college = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("College", collegeId + ""));
        college.setCollegeCode(collegeDto.getCollegeCode());
        college.setName(collegeDto.getName());
        college.setLocation(collegeDto.getLocation());
        College updated = this.collegeRepo.save(college);
        return this.modelMapper.map(updated, CollegeDto.class);
    }

    @Override
    public void deleteCollege(int collegeId) {
        College college = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("College", collegeId + ""));
        this.collegeRepo.delete(college);
    }

    @Override
    public List<CollegeDto> getColleges() {

        List<College> all = this.collegeRepo.findAll();
        return all
                .stream()
                .map(college -> this.modelMapper.map(college, CollegeDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public CollegeDto getCollegeById(int collegeId) {
        College college = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("College", collegeId + ""));
        return this.modelMapper.map(college, CollegeDto.class);
    }

    @Override
    public List<CollegeDto> getCollegeOfUniversity(int universityId) {
        University university = this.universityRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("University ", universityId + ""));
        List<College> byUniversity = this.collegeRepo.findByUniversity(university);
        List<CollegeDto> collect = byUniversity.stream().map((c) -> this.modelMapper.map(c, CollegeDto.class)).collect(Collectors.toList());
        return collect;
    }
}
