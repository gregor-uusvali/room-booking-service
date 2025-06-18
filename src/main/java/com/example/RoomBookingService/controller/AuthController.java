package com.example.RoomBookingService.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoomBookingService.service.LoginService;
import com.example.RoomBookingService.service.TokenService;

@RestController
public class AuthController {

  private final TokenService tokenService;
  private final LoginService loginService;

  public AuthController(TokenService tokenService, LoginService loginService) {
    this.tokenService = tokenService;
    this.loginService = loginService;
  }

  @PostMapping("/token")
  public String token(Authentication authentication) {
    return tokenService.generateToken(authentication);
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
    return loginService.login(credentials);
  }
}
