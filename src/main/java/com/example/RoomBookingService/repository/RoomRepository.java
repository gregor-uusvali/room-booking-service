package com.example.RoomBookingService.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RoomBookingService.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  @Query("SELECT r FROM Room r WHERE r.id NOT IN " + 
  "(SELECT b.roomId FROM Booking b WHERE b.checkInDate <= :endDate AND b.checkOutDate >= :startDate)")
  List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

  @Query("Select COUNT(r) FROM Room r")
  int getTotalRooms();
}
