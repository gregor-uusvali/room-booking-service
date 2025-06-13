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
    if(booking.getCheckInDate().isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Check-in date cannot be in the past");
    }
    if(booking.getCheckOutDate().isBefore(booking.getCheckInDate())) {
      throw new IllegalArgumentException("Check-out date cannot be before check-in date");
    }
    if(booking.getCheckOutDate().isAfter(booking.getCheckInDate().plusDays(30))) {
      throw new IllegalArgumentException("Check-out date cannot be more than 30 days after check-in date");
    }
    if(bookingRepository.findByCheckInDateBetween(booking.getCheckInDate(), booking.getCheckOutDate()).size() >= 10) {
      throw new IllegalArgumentException("Room is already booked for the selected dates");
    }
    Booking bookingEntity = bookingRepository.save(booking);
    return BookingDTO.builder()
      .room(roomRepository.findById(bookingEntity.getRoomId()).orElse(null))
      .userId(bookingEntity.getUserId())
      .bookingDate(bookingEntity.getBookingDate())
      .checkInDate(bookingEntity.getCheckInDate())
      .checkOutDate(bookingEntity.getCheckOutDate())
      .build();
  }

  public List<Booking> getMonthsBookings(String month) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate monthDate = LocalDate.parse(month + "-01", formatter);
    LocalDate endOfMonth = monthDate.withDayOfMonth(monthDate.lengthOfMonth());
    return bookingRepository.findByCheckInDateBetween(monthDate, endOfMonth);
  }
}
