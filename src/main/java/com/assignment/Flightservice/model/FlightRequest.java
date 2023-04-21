package com.assignment.Flightservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FlightRequest {
    @Id
    @GeneratedValue
    private int id;
    private int PlaceId;
    private int FlightId;
    private String requestStatus;

    public FlightRequest() {}

    public FlightRequest(int id, int PlaceId, int FlightId, String requestStatus) {
        this.id = id;
        this.PlaceId = PlaceId;
        this.FlightId = FlightId;
        this.requestStatus = requestStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        this.PlaceId = placeId;
    }

    public int getFlightId() {
        return FlightId;
    }

    public void setFlightId(int flightId) {
        this.FlightId = flightId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                "id=" + id +
                ", placeId=" + PlaceId +
                ", flightId=" + FlightId +
                ", requestStatus='" + requestStatus + '\'' +
                '}';
    }
}
