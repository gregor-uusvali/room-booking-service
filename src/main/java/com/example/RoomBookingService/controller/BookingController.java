package com.example.RoomBookingService.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoomBookingService.DTO.BookingDTO;
import com.example.RoomBookingService.entity.Booking;
import com.example.RoomBookingService.service.BookingService;
import com.example.RoomBookingService.transformer.DateTransformer;

@RestController
public class BookingController {

  private final BookingService bookingService;
  private final String currentMonth;

  public BookingController(BookingService bookingService, DateTransformer dateTransformer) {
    this.bookingService = bookingService;
    this.currentMonth = dateTransformer.transformLocalDateToString(LocalDate.now().withDayOfMonth(1), "yyyy-MM");
  }

  @PostMapping("/bookings")
  public BookingDTO createBooking(@RequestBody Booking booking) {
    return bookingService.createBooking(booking);
  }

  @GetMapping("/bookings")
  public List<Booking> getBookings(@RequestParam(required = false) String month) {
    return bookingService.getMonthsBookings(month != null ? month : currentMonth);
  }
}
