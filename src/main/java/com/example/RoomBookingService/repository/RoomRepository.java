package com.example.RoomBookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RoomBookingService.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
