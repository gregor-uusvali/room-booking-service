package com.example.RoomBookingService.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "room_number")
  private String roomNumber;

  @Column(name = "room_price")
  private Double roomPrice;

  // @Column(name = "room_type")
  // private String roomType;

  // @Column(name = "room_capacity")
  // private Integer roomCapacity;

  // @Column(name = "room_description")
  // private String roomDescription;

  // @Column(name = "room_status")
  // private String roomStatus;

  // @Column(name = "room_image")
  // private String roomImage;
  
}
