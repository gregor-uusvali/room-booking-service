package com.example.RoomBookingService;

import com.example.RoomBookingService.TestConfig;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.RoomBookingService.controller.HomeController;

@SuppressWarnings("unused")
@WebMvcTest(HomeController.class)
@Import(TestConfig.class)
public class HomeControllerIntTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void testHome() throws Exception {
    RequestBuilder req = MockMvcRequestBuilders.get("/")
        .with(csrf());
    MvcResult res = mvc.perform(req).andReturn();
    assertEquals("Welcome to the Room Booking Service Anonymous", res.getResponse().getContentAsString());
  }
}
