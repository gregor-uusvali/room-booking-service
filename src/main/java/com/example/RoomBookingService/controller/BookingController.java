package com.example.RoomBookingService.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoomBookingService.entity.Booking;
import com.example.RoomBookingService.DTO.BookingDTO;
import com.example.RoomBookingService.service.BookingService;

@RestController
public class BookingController {

  private final BookingService bookingService;
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private final String startDate = LocalDate.now().withDayOfMonth(1).format(formatter);
  private final String endDate = LocalDate.now().plusMonths(1).minusDays(1).format(formatter);

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping("/bookings")
  public BookingDTO createBooking(@RequestBody Booking booking) {
    System.out.println("Creating booking");
    System.out.println(booking);
    return bookingService.createBooking(booking);
  }

  @GetMapping("/bookings")
  public List<Booking> getBookings(@RequestParam(required = false) String start, @RequestParam(required = false) String end) {
    return bookingService.getMonthsBookings(start != null ? start : startDate, end != null ? end : endDate);
  }
}
