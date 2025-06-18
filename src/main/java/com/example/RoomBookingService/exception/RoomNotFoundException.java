package com.example.RoomBookingService.exception;

public class RoomNotFoundException extends RuntimeException {
    
    public RoomNotFoundException(Long roomId) {
        super("Room not found with ID: " + roomId);
    }

} 