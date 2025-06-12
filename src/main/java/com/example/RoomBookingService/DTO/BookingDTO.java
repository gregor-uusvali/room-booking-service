package com.example.RoomBookingService.DTO;

import java.time.LocalDate;

import com.example.RoomBookingService.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {
  private Room room;
  private Long userId;
  private LocalDate bookingDate;
  private LocalDate checkInDate;
  private LocalDate checkOutDate;
}
