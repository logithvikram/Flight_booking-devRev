package com.assignment.Flightservice.repository;

import com.assignment.Flightservice.model.FlightRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface FlightRequestRepository extends JpaRepository<FlightRequest,Integer> {
}
