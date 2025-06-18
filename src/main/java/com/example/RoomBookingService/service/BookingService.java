package com.example.RoomBookingService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RoomBookingService.DTO.BookingDTO;
import com.example.RoomBookingService.entity.Booking;
import com.example.RoomBookingService.entity.Room;
import com.example.RoomBookingService.exception.RoomNotFoundException;
import com.example.RoomBookingService.repository.BookingRepository;
import com.example.RoomBookingService.repository.RoomRepository;
import com.example.RoomBookingService.transformer.DateTransformer;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;
  private final RoomRepository roomRepository;
  private final DateTransformer dateTransformer;

  public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, DateTransformer dateTransformer) {
    this.bookingRepository = bookingRepository;
    this.roomRepository = roomRepository;
    this.dateTransformer = dateTransformer;
  }

  public BookingDTO createBooking(Booking booking) {
    // Validate room exists first
    if (booking.getRoomId() == null) {
      throw new IllegalArgumentException("Room ID is required");
    }

    Room room = roomRepository.findById(booking.getRoomId())
        .orElseThrow(() -> new RoomNotFoundException(booking.getRoomId()));

    if (booking.getCheckInDate().isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Check-in date cannot be in the past");
    }

    if (booking.getCheckOutDate().isBefore(booking.getCheckInDate())) {
      throw new IllegalArgumentException("Check-out date cannot be before check-in date");
    }

    if (booking.getCheckOutDate().isAfter(booking.getCheckInDate().plusDays(30))) {
      throw new IllegalArgumentException("Check-out date cannot be more than 30 days after check-in date");
    }
    
    List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(
        booking.getRoomId(),
        booking.getCheckInDate(),
        booking.getCheckOutDate());

    if (!overlappingBookings.isEmpty()) {
      throw new IllegalArgumentException("Room is already booked for the selected dates");
    }
    
    Booking bookingEntity = bookingRepository.save(booking);
    return BookingDTO.builder()
        .room(room)
        .userId(bookingEntity.getUserId())
        .bookingDate(bookingEntity.getBookingDate())
        .checkInDate(bookingEntity.getCheckInDate())
        .checkOutDate(bookingEntity.getCheckOutDate())
        .build();

  }

  public List<Booking> getMonthsBookings(String month) {
    LocalDate monthDate = dateTransformer.transformStringToLocalDate(month, "yyyy-MM-dd");
    LocalDate endOfMonth = monthDate.withDayOfMonth(monthDate.lengthOfMonth());
    return bookingRepository.findByCheckInDateBetween(monthDate, endOfMonth);
  }
}
