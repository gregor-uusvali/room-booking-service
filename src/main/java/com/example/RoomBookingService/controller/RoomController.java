package com.example.RoomBookingService.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoomBookingService.entity.Room;
import com.example.RoomBookingService.service.RoomService;

@RestController
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("/rooms")
  public List<Room> getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/rooms/available")
  public List<Room> getAvailableRooms(@RequestParam String startDate, @RequestParam String endDate) {
    return roomService.getAvailableRooms(startDate, endDate);
  }

  @GetMapping("/rooms/availableDates")
  public List<LocalDate> getAvailableDates(@RequestParam String month) {
    return roomService.getAvailableDates(month);
  }

}
