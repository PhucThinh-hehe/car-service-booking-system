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
//dto imports
import com.example.carservicebooking.dto.request.UserCreatetionRequest;
import com.example.carservicebooking.dto.request.UserUpdateRequest;
//entity imports
import com.example.carservicebooking.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users") 
public class UserController {
    
    @Autowired
    private UserService userService; 

    @PostMapping
    User createUser(@RequestBody UserCreatetionRequest request) {
        return userService._createUser(request);
    }

    @GetMapping("/getAllUsers")
   List<User> getUsers() {
       
        return userService._getAllUsers();
    }
    @GetMapping("/getById/{id}")
    User getUserById(@PathVariable String id) {
        return userService._getUserById(id);
    }

    @PutMapping("/updateById/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
       return userService._updateUser(id, request); 
    }

    @DeleteMapping("/deleteById/{id}")
    String deleteUser(@PathVariable String id) {
        userService._deleteUser(id);
        return "User with id " + id + " has been deleted.";
    }

}