package com.project.service.impl;

import com.project.entity.*;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.UserDto;
import com.project.repository.UserRepo;
import com.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

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
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user",  userId + ""));
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
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user",  userId + ""));
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
}
