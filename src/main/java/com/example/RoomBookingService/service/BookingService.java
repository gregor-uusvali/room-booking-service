package com.example.RoomBookingService.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RoomBookingService.DTO.BookingDTO;
import com.example.RoomBookingService.entity.Booking;
import com.example.RoomBookingService.repository.BookingRepository;
import com.example.RoomBookingService.repository.RoomRepository;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;
  private final RoomRepository roomRepository;

  public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
    this.bookingRepository = bookingRepository;
    this.roomRepository = roomRepository;
  }

  public BookingDTO createBooking(Booking booking) {
    Booking bookingEntity = bookingRepository.save(booking);
    return BookingDTO.builder()
      .room(roomRepository.findById(bookingEntity.getRoomId()).orElse(null))
      .userId(bookingEntity.getUserId())
      .bookingDate(bookingEntity.getBookingDate())
      .checkInDate(bookingEntity.getCheckInDate())
      .checkOutDate(bookingEntity.getCheckOutDate())
      .build();
  }

  public List<Booking> getMonthsBookings(String startDate, String endDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate start = LocalDate.parse(startDate, formatter);
    LocalDate end = LocalDate.parse(endDate, formatter);
    return bookingRepository.findByBookingDateBetween(start, end);
  }
}
