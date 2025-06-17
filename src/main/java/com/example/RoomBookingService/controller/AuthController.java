package com.example.RoomBookingService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoomBookingService.entity.User;
import com.example.RoomBookingService.service.TokenService;
import com.example.RoomBookingService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {

  private final TokenService tokenService;
  private final UserService userService;

  public AuthController(TokenService tokenService, UserService userService) {
    this.tokenService = tokenService;
    this.userService = userService;
  }

  @PostMapping("/token")
  public String token(Authentication authentication) {
    log.info("Token requested for user: {}", authentication.getName());
    String token = tokenService.generateToken(authentication);
    log.info("Token granted: {}", token);
    return token;
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    
    log.info("Login requested for user: {}", username);
    
    try {
        User user = userService.login(username, password);
        
        // Create authentication for token generation
        Authentication auth = new UsernamePasswordAuthenticationToken(
            username, 
            null, 
            List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        
        String token = tokenService.generateToken(auth);
        
        return ResponseEntity.ok(Map.of(
            "token", token,
            "user", user
        ));
    } catch (Exception e) {
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
  }
}
