package com.example.RoomBookingService.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "room_id")
  private Long roomId;

  @Column(name = "user_id")
  private Long userId;
  
  @CreationTimestamp
  @Column(name = "booking_date")
  private LocalDate bookingDate;

  @Column(name = "check_in_date")
  private LocalDate checkInDate;

  @Column(name = "check_out_date")
  private LocalDate checkOutDate;
}
