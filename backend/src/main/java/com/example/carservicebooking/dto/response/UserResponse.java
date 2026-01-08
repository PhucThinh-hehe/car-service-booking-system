package com.example.carservicebooking.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponse {
    String id;
     String username;
     String password;
     String firstName;
     String lastName; 
     String address;
     LocalDate dateOfBirth;
     String phoneNumber;
     String email;
     String role;
     boolean isActive;
     LocalDate createdAt;

}
