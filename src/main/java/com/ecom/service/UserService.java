package com.ecom.service;

import com.ecom.entity.User;
import com.ecom.payload.UserDto;

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

}
