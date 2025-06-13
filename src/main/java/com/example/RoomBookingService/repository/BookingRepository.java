package com.example.RoomBookingService.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RoomBookingService.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByCheckInDateBetween(LocalDate startDate, LocalDate endDate);

  @Query("SELECT b FROM Booking b WHERE b.roomId = :roomId AND " +
      "b.checkInDate < :checkOut AND b.checkOutDate > :checkIn")
  List<Booking> findOverlappingBookings(
      @Param("roomId") Long roomId,
      @Param("checkIn") LocalDate checkIn,
      @Param("checkOut") LocalDate checkOut);

  @Query("SELECT b.checkInDate FROM Booking b WHERE b.roomId = :roomId AND " +
      "b.checkInDate < :checkOut AND b.checkOutDate > :checkIn")
  List<LocalDate> findAvailableDates(
      @Param("roomId") Long roomId,
      @Param("checkIn") LocalDate checkIn);
}