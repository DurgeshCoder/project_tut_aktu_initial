package com.project.service.impl;

import com.project.entity.*;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.UserDto;
import com.project.payload.UserRegisterRequest;
import com.project.repository.*;
import com.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UniversityRepo universityRepo;

    @Autowired
    private CollegeRepo collegeRepo;

    @Autowired
    private CourseRepo courseRepo;


    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.mapper.map(userDto, User.class);
        User savedUser = this.userRepo.save(user);
        return this.mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(int userId, UserDto userDto) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", userId + ""));
        user.setName(userDto.getName());
        user.setLink(userDto.getLink());
        user.setCollege(this.mapper.map(userDto.getCollege(), College.class));
        user.setBranch(this.mapper.map(userDto.getBranch(), Branch.class));
        user.setCourse(this.mapper.map(userDto.getCourse(), Course.class));
        user.setUniversity(this.mapper.map(userDto.getUniversity(), University.class));
        user.setYear(userDto.getYear());
        user.setPhone(userDto.getPhone());
        User save = this.userRepo.save(user);
        return this.mapper.map(save, UserDto.class);
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", userId + ""));
        this.userRepo.delete(user);
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", userId + ""));
        return this.mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user", email + ""));
        return this.mapper.map(user, UserDto.class);
    }

    @Override
    public boolean checkUserByEmail(String email) {
        Boolean aBoolean = this.userRepo.existsByEmail(email);
        return aBoolean;
    }

    @Override
    public UserDto registerUser(UserRegisterRequest userRegisterRequest) {

        University university = this.universityRepo.findById(userRegisterRequest.getUniversityId()).orElseThrow(() -> new ResourceNotFoundException(" University ", userRegisterRequest.getUniversityId() + ""));
        College college = this.collegeRepo.findById(userRegisterRequest.getCollegeId()).orElseThrow(() -> new ResourceNotFoundException("College ", userRegisterRequest.getCollegeId() + ""));
        Course course = this.courseRepo.findById(userRegisterRequest.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("Course ", userRegisterRequest.getCourseId() + ""));
        Branch branch = this.branchRepo.findById(userRegisterRequest.getBranchId()).orElseThrow(() -> new ResourceNotFoundException("Branch ", userRegisterRequest.getBranchId() + ""));

        User user = new User();
        user.setEmail(userRegisterRequest.getEmail());
        user.setName(userRegisterRequest.getName());
        user.setLink(userRegisterRequest.getLink());
        user.setUniversity(university);
        user.setCollege(college);
        user.setCourse(course);
        user.setBranch(branch);
        user.setPhone(userRegisterRequest.getPhone());
        user.setYear(userRegisterRequest.getYear());
        user.setSemester(userRegisterRequest.getSemester());

        User save = this.userRepo.save(user);
        return this.mapper.map(save, UserDto.class);
    }
}
