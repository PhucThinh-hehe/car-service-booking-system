package com.example.carservicebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.carservicebooking.service.UserService;

import jakarta.validation.Valid;

import com.example.carservicebooking.dto.request.ApiResponse;
//dto imports
import com.example.carservicebooking.dto.request.UserCreatetionRequest;
import com.example.carservicebooking.dto.request.UserUpdateRequest;
import com.example.carservicebooking.dto.response.UserResponse;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users") 
public class UserController {
    
    @Autowired
    private UserService userService; 

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreatetionRequest request) {

        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.setResult(userService._createUser(request));
        return response;
    }

    @GetMapping("/getAllUsers")
   List<UserResponse> getUsers() {
       
        return userService._getAllUsers();
    }
    @GetMapping("/getById/{id}")
    UserResponse getUserById(@PathVariable String id) {
        return userService._getUserById(id);
    }

    @PutMapping("/updateById/{id}")
    UserResponse updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
       return userService._updateUser(id, request); 
    }

    @DeleteMapping("/deleteById/{id}")
    String deleteUser(@PathVariable String id) {
        userService._deleteUser(id);
        return "User with id " + id + " has been deleted.";
    }

}