package com.example.RoomBookingService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.RoomBookingService.controller.HomeController;

class HomeControllerTest {

  @Test
  void testHome() {
    // arrange
    HomeController homeController = new HomeController();
    // act
    String expectedString = "Welcome to the Room Booking Service Anonymous";
    String actual = homeController.home(null);
    // assert
    assertEquals(expectedString, actual);
  }

}
