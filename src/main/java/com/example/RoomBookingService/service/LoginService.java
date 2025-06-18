package com.example.RoomBookingService.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.RoomBookingService.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

  private final UserService userService;
  private final TokenService tokenService;

  public LoginService(UserService userService, TokenService tokenService) {
    this.userService = userService;
    this.tokenService = tokenService;
  }

  public ResponseEntity<Map<String, Object>> login(Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    
    log.info("Login requested for user: {}", username);
    
    User user = userService.login(username, password);
    
    // Create authentication for token generation
    List<SimpleGrantedAuthority> authorities = Arrays.asList(user.getRole().split(","))
        .stream()
        .map(SimpleGrantedAuthority::new)
        .toList();
        
    Authentication auth = new UsernamePasswordAuthenticationToken(
        username, 
        null, 
        authorities
    );
    
    String token = tokenService.generateToken(auth);
    
    return ResponseEntity.ok(Map.of(
        "token", token,
        "user", user
    ));
  }
}
