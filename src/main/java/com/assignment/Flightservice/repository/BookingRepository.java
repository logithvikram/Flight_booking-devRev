package com.assignment.Flightservice.repository;

import com.assignment.Flightservice.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByUsername(String username);
    void deleteByUsername(String username);
}
