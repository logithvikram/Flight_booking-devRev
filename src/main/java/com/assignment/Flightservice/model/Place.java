package com.assignment.Flightservice.model;

import jakarta.persistence.*;

@Entity
public class Place {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;

    private Integer assignedFlightId;
    private String usedFlightIds;

    public Place() {}
    public Place(Integer id, String username, Integer assignedFlightId, String usedFlightIds) {
        this.id = id;
        this.username = username;
        this.assignedFlightId = assignedFlightId;
        this.usedFlightIds = usedFlightIds;
    }

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

    public String getUsedFlightIds() {
        return usedFlightIds;
    }

    public void setUsedFlightIds(String usedFlightIds) {
        this.usedFlightIds = usedFlightIds;
    }

    public Integer getAssignedFlightId() {
        return assignedFlightId;
    }

    public void setAssignedFlightId(Integer assignedFlightId) {
        this.assignedFlightId = assignedFlightId;
    }


    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", assignedFlightId=" + assignedFlightId +
                ", usedFlightIds='" + usedFlightIds + '\'' +
                '}';
    }
}
