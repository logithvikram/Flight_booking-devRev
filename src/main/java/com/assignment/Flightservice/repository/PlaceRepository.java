package com.assignment.Flightservice.repository;

import com.assignment.Flightservice.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
}
