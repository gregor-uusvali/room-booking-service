package com.example.RoomBookingService.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RoomBookingService.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
}