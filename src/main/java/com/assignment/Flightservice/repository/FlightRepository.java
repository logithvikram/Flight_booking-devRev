package com.assignment.Flightservice.repository;

import com.assignment.Flightservice.model.Flight;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Transactional
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    //List<Car> findBySeatingCapacityAndavailableForBooking(int seatingCapacity,boolean availableForBooking);
    List<Flight> findBySeatingCapacityAndAvailableForBookingTrue(int seatingCapacity);

    List<Flight> findByIdIn(List<Integer> carIds);
}
