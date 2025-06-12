package com.example.RoomBookingService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RoomBookingService.entity.Room;
import com.example.RoomBookingService.repository.RoomRepository;

@Service
public class RoomService {

  private final RoomRepository roomRepository;

  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  } 

  public List<Room> getRooms() {
    return roomRepository.findAll();
  }
}
