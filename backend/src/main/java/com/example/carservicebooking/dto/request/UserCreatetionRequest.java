package com.example.carservicebooking.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatetionRequest {
    @Size(min = 3, max = 20, message = "USERNAME_INVALID")
    @NotEmpty(message = "USERNAME_EMPTY")
    private String username;
    @Size(min = 6, message = "PASSWORD_INVALID")
    @NotEmpty(message = "PASSWORD_EMPTY")
    private String password;
    @NotEmpty(message = "FIRST_NAME_EMPTY")
    private String firstName;
    @NotEmpty(message = "LAST_NAME_EMPTY")
    private String lastName; 
    private String address;

    private LocalDate dateOfBirth;
    private String phoneNumber;
    @Email(message = "Email should be valid")
    private String email;
    private String role;
    private boolean isActive;
    private LocalDate createdAt;
    // Getters and Setters


   
    

}
