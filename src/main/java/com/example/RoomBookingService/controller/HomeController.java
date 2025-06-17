package com.example.RoomBookingService.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home(Principal principal) {
    return "Welcome to the Room Booking Service " + (principal != null ? principal.getName() : "Anonymous");
  }

  @GetMapping("/admin")
  public String admin() {
    return "Welcome Admin to the Room Booking Service";
  }
}
