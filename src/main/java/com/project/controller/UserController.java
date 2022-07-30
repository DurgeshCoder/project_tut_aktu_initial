package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.UserDto;
import com.project.payload.UserRegisterRequest;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto user = this.userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
    //get

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        UserDto user = this.userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("email/{userId}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserDto user = this.userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //check
    @GetMapping("/check/{email}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable String email) {
        boolean f = this.userService.checkUserByEmail(email);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("User exits with this email in database");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //user register
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(
            @RequestBody UserRegisterRequest userRegisterRequest
    ) {
        UserDto dto = this.userService.registerUser(userRegisterRequest);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
