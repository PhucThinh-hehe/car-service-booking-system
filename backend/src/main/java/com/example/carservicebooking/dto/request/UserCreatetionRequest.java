package com.example.carservicebooking.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    

}
