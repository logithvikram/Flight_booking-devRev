package com.assignment.Flightservice.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private Integer flightId;
    private Integer PlaceId;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(Integer driverId) {
        this.PlaceId = driverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer carId) {
        this.flightId = carId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", username=" + username +
                ", flightId=" + flightId +
                ", PlaceId=" + PlaceId +
                ", status='" + status + '\'' +
                '}';
    }
}
