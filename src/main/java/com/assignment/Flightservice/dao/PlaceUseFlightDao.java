package com.assignment.Flightservice.dao;

import com.assignment.Flightservice.model.Flight;

import java.util.List;

public class PlaceUseFlightDao {
    private int PlaceId;
    private String placeName;
    private List<Flight> usedFlights;

    public PlaceUseFlightDao() {}

    public PlaceUseFlightDao(int PlaceId, String placeName, List<Flight> usedFlights) {
        this.PlaceId = PlaceId;
        this.placeName = placeName;
        this.usedFlights = usedFlights;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        this.PlaceId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public List<Flight> getUsedCars() {
        return usedFlights;
    }

    public void setUsedCars(List<Flight> usedFlights) {
        this.usedFlights = usedFlights;
    }

    @Override
    public String toString() {
        return "DriverUseCarsDao{" +
                "PlaceId=" + PlaceId +
                ", PlaceName='" + placeName + '\'' +
                ", usedFlights=" + usedFlights +
                '}';
    }
}
