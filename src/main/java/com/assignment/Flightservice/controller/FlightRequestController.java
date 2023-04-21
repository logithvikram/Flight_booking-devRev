package com.assignment.Flightservice.controller;

import com.assignment.Flightservice.model.Flight;
import com.assignment.Flightservice.model.FlightRequest;
import com.assignment.Flightservice.model.Place;
import com.assignment.Flightservice.repository.FlightRepository;
import com.assignment.Flightservice.repository.FlightRequestRepository;
import com.assignment.Flightservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlightRequestController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    FlightRequestRepository flightRequestRepository;

    @RequestMapping("approve-request")
    public String approvePlaceRequest(@RequestParam int requestId,
                                       @RequestParam int placeId,
                                       @RequestParam int flightId) throws Exception {
        Place place = placeRepository.findById(placeId).orElseThrow(() ->
                new Exception("Place not found with placeID - " + placeId));
        place.setAssignedFlightId(flightId);
        place.setUsedFlightIds(place.getUsedFlightIds()+","+ flightId);
        Flight flight = flightRepository.findById(flightId).orElseThrow(() ->
                new Exception("Flight not found with flightID - " + flightId));

        FlightRequest flightRequest = flightRequestRepository.findById(requestId).orElseThrow(() ->
                new Exception("Request not found with requestID - " + requestId));
        flightRequest.setRequestStatus("APPROVED");
        flight.setPlaceId(placeId);
        flightRequestRepository.save(flightRequest);
        flightRepository.save(flight);
        placeRepository.save(place);
        return "redirect:/list-flight-requests";
    }

    @RequestMapping("reject-request")
    public String rejectPlaceRequest(@RequestParam int requestId) throws Exception {
        FlightRequest flightRequest = flightRequestRepository.findById(requestId).orElseThrow(() ->
                new Exception("Request not found with requestID - " + requestId));
        flightRequest.setRequestStatus("REJECTED");
        flightRequestRepository.save(flightRequest);
        return "redirect:/list-flight-requests";
    }

    @RequestMapping("delete-flight-requests")
    public String rejectPlaceRequest()  {
        flightRequestRepository.deleteAll();
        return "redirect:/list-flight-requests";
    }


    @RequestMapping("list-flight-requests")
    public String listAllFlightRequests(ModelMap modelMap) {
        List<FlightRequest> flightRequests = flightRequestRepository.findAll();
        modelMap.put("flight_requests", flightRequests);
        return "listFlightRequests";
    }

}
