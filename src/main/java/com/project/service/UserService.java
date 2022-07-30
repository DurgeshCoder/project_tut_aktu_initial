package com.project.service;

import com.project.payload.UserDto;
import com.project.payload.UserRegisterRequest;

public interface UserService {

    //create
    public UserDto createUser(UserDto userDto);

    //upadte
    public UserDto updateUser(int userId, UserDto userDto);

    //delete
    public void deleteUser(int userId);

    //get user

    public UserDto getUserById(int userId);

    public UserDto getUserByEmail(String email);

    //
    public boolean checkUserByEmail(String email);

    UserDto registerUser(UserRegisterRequest userRegisterRequest);

}
