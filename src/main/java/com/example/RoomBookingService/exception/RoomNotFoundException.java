package com.example.RoomBookingService.exception;

public class RoomNotFoundException extends RuntimeException {
    
    public RoomNotFoundException(String message) {
        super(message);
    }
    
    public RoomNotFoundException(Long roomId) {
        super("Room not found with ID: " + roomId);
    }
    
    public RoomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
} 