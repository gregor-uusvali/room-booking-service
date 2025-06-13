package com.example.RoomBookingService.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RoomBookingService.entity.Room;
import com.example.RoomBookingService.repository.RoomRepository;
import com.example.RoomBookingService.transformer.DateTransformer;

@Service
public class RoomService {

  private final RoomRepository roomRepository;
  private final DateTransformer dateTransformer;

  public RoomService(RoomRepository roomRepository, DateTransformer dateTransformer) {
    this.roomRepository = roomRepository;
    this.dateTransformer = dateTransformer;
  } 

  public List<Room> getRooms() {
    return roomRepository.findAll();
  }

  public List<Room> getAvailableRooms(String startDate, String endDate) {
    LocalDate start = dateTransformer.transformStringToLocalDate(startDate, "yyyy-MM-dd");
    LocalDate end = dateTransformer.transformStringToLocalDate(endDate, "yyyy-MM-dd");
    if (start.isAfter(end)) {
      throw new IllegalArgumentException("Start date cannot be after end date");
    }
    return roomRepository.findAvailableRooms(start, end);
  }

  public List<LocalDate> getAvailableDates(String month) {
    LocalDate monthDate = dateTransformer.transformStringToLocalDate(month, "yyyy-MM-dd");
    List<LocalDate> availableDates = new ArrayList<>();
    for (int i = 0; i < monthDate.lengthOfMonth(); i++) {
      LocalDate date = monthDate.withDayOfMonth(i + 1);
      if (!roomRepository.findAvailableRooms(date, date).isEmpty()) {
        availableDates.add(date);
      }
    }
    return availableDates;
  }
}
