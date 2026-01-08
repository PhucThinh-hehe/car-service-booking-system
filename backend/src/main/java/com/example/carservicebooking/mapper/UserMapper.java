package com.example.carservicebooking.mapper;

import org.mapstruct.Mapper;

import com.example.carservicebooking.entity.User;
import com.example.carservicebooking.dto.request.UserCreatetionRequest;
import com.example.carservicebooking.dto.response.UserResponse;
import org.mapstruct.MappingTarget;
import com.example.carservicebooking.dto.request.UserUpdateRequest;
import java.util.List;

@Mapper (componentModel = "spring")
public interface UserMapper {
User creatUser (UserCreatetionRequest request);
UserResponse toUserResponse (User user);
List<UserResponse> toAllUserResponse (List<User> users);

 void updateUser(@MappingTarget User user,  UserUpdateRequest request); 
    
}
