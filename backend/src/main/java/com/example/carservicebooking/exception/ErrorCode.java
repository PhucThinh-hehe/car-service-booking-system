package com.example.carservicebooking.exception;

public enum ErrorCode {
    USER_NOT_FOUND(1001, "User not found"),
    USER_EXISTED(1003, "User already exists"),

    //
    USERNAME_INVALID(1004, "Username must be between 3 and 20 characters"),
    USERNAME_EMPTY(1005, "Username cannot be null"),
    PASSWORD_INVALID(1006, "Password is invalid"),
    PASSWORD_EMPTY(1007, "Password cannot be null"),
    FIRSTNAME_EMPTY(1008, "First name cannot be null"),
    LASTNAME_EMPTY(1009, "Last name cannot be null"),
    
    
    // Booking related errors
    INVALID_CREDENTIALS(1002, "Invalid credentials"),
    BOOKING_NOT_FOUND(2001, "Booking not found"),
    SERVICE_UNAVAILABLE(3001, "Service is currently unavailable"),
    UNCATEGORIZED_ERROR(9999, "An uncategorized error occurred");


    

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
}
