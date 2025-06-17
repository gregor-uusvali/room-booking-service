package com.example.RoomBookingService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "Welcome to the Room Booking Service";
  }

  @GetMapping("/admin")
  public String admin() {
    return "Welcome Admin to the Room Booking Service";
  }
}
