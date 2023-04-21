package com.assignment.Flightservice.controller;

import com.assignment.Flightservice.exception.InvalidSeatingCapacityException;
import com.assignment.Flightservice.model.Flight;
import com.assignment.Flightservice.model.Place;
import com.assignment.Flightservice.repository.FlightRepository;
import com.assignment.Flightservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @RequestMapping("list-flights")
    public String listAllFlights(ModelMap modelMap) {
        List<Flight> flights = flightRepository.findAll();
        modelMap.put("flights", flights);
        return "listFlights";
    }

    @RequestMapping("list-available-flights")
    public String listAllAvailableFlightsForBooking(@RequestParam int seatingCapacity, ModelMap modelMap) {
        List<Flight> flights = flightRepository.findBySeatingCapacityAndAvailableForBookingTrue(seatingCapacity);
        modelMap.put("flights", flights);
        return "listFlightsAvailableForBooking";
    }

    @RequestMapping(value="add-flight",method= RequestMethod.GET)
    public String showNewFlightPage(Flight flight) {
        return "flight";
    }


    @RequestMapping(value="add-flight",method= RequestMethod.POST)
    public String addNewFlight(Flight flight) throws Exception {
        int capacity= flight.getSeatingCapacity();
        if(capacity!=1 && capacity!=2 && capacity!=3) {
            throw  new InvalidSeatingCapacityException("There is only class are Economy class,Business class,Sleeper class");
        }

        flight.setAvailableForBooking(true);
        flightRepository.save(flight);
        return "redirect:list-flights";
    }

    @RequestMapping(value="delete-flight")
    public String deleteFlight(@RequestParam int id) {
        flightRepository.deleteById(id);
        return "redirect:list-flights";
    }



    @GetMapping(value="assign-flight/flightId/{flightId}/placeId/{placeId}")
    public String assignPlaceToFlight(@PathVariable int flightId,@PathVariable int placeId) throws Exception {
        Place place = placeRepository.findById(placeId).orElseThrow(() ->
                new Exception("place not found with placeID - " + placeId));
        int previousAssignedFlightId= place.getAssignedFlightId();
        place.setAssignedFlightId(flightId);
        place.setUsedFlightIds(place.getUsedFlightIds()+","+flightId);
        Flight previousAssignedFlight = flightRepository.findById(previousAssignedFlightId).orElseThrow(() ->
                new Exception("Flight not found with FlightID - " + previousAssignedFlightId));;
        previousAssignedFlight.setPlaceId(null);
        Flight flight = flightRepository.findById(flightId).orElseThrow(() ->
                new Exception("Flight not found with FlightID - " + flightId));;
        flight.setPlaceId(placeId);
        flightRepository.save(previousAssignedFlight);
        flightRepository.save(flight);
        placeRepository.save(place);
        return "redirect:/list-flights";
    }
}
