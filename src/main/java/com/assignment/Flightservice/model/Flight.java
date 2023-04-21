package com.assignment.Flightservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Integer id;
    private String model;
    private String classs;
    private Integer seatingCapacity;
    private boolean availableForBooking;
    private Integer PlaceId;

    public Flight() {}
    public Flight(Integer id, String model, String color, Integer seatingCapacity, boolean availableForBooking, Integer PlaceId) {
        this.id = id;
        this.model = model;
        this.classs = color;
        this.seatingCapacity = seatingCapacity;
        this.availableForBooking=availableForBooking;
        this.PlaceId = PlaceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return classs;
    }

    public void setColor(String color) {
        this.classs = color;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isAvailableForBooking() {
        return availableForBooking;
    }

    public void setAvailableForBooking(boolean availableForBooking) {
        this.availableForBooking = availableForBooking;
    }

    public Integer getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(Integer placeId) {
        this.PlaceId = placeId;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + classs + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", availableForBooking=" + availableForBooking +
                ", placeId=" + PlaceId +
                '}';
    }
}
