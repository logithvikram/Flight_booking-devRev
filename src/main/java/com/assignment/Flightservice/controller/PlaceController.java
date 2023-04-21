package com.assignment.Flightservice.controller;

import com.assignment.Flightservice.dao.PlaceUseFlightDao;
import com.assignment.Flightservice.model.Flight;
import com.assignment.Flightservice.model.FlightRequest;
import com.assignment.Flightservice.model.Place;
import com.assignment.Flightservice.repository.FlightRepository;
import com.assignment.Flightservice.repository.FlightRequestRepository;
import com.assignment.Flightservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightRequestRepository flightRequestRepository;

    @RequestMapping("list-places")
    public String listAllPlaces(ModelMap modelMap) {
        List<Place> places = placeRepository.findAll();
        modelMap.put("places", places);
        return "listPlaces";
    }

    @GetMapping("place/used-flights")
    @ResponseBody
    public PlaceUseFlightDao getFlightsUsedByPlace(@RequestParam int placeId) throws Exception {
        Optional<Place> PlaceOptional= placeRepository.findById(placeId);
        if(PlaceOptional.isPresent()) {
            Place place =PlaceOptional.get();
            String[] usedFlight= place.getUsedFlightIds().split(",");
            List<Integer> flightIds=new ArrayList<>();
            for(String FlightId:usedFlight) {
                flightIds.add(Integer.parseInt(FlightId));
            }

            List<Flight> flightList = flightRepository.findByIdIn(flightIds);
            PlaceUseFlightDao placeUseFlightDao =new PlaceUseFlightDao(placeId, place.getUsername(), flightList);

            return placeUseFlightDao;
        }

        throw new Exception("Place not found");
    }

    @RequestMapping(value="add-place",method= RequestMethod.GET)
    public String showNewPlacePage(Place place) {
        return "place";
    }


    @RequestMapping(value="add-place",method= RequestMethod.POST)
    public String addNewPlace(Place place) {
        place.setUsedFlightIds(""+ place.getAssignedFlightId());
        Place savedPlace = placeRepository.save(place);
        Flight flight = flightRepository.findById(place.getAssignedFlightId()).get();
        flight.setPlaceId(savedPlace.getId());
        flightRepository.save(flight);
        return "redirect:list-places";
    }
    @RequestMapping(value="delete-place")
    public String deletePlace(@RequestParam int id) throws Exception {
        Place place = placeRepository.findById(id).orElseThrow(() ->
                new Exception("Place not found with PlaceID - " + id));
        Flight flight = flightRepository.findById(place.getAssignedFlightId()).orElseThrow(() ->
                new Exception("Flight not found with FlightID - " + place.getAssignedFlightId()));
        flight.setAvailableForBooking(true);
        flight.setPlaceId(null);
        flightRepository.save(flight);
        placeRepository.deleteById(id);
        return "redirect:list-places";
    }

    @GetMapping(value="request-flight")
    public String requestNewFlight(@RequestParam int placeId, @RequestParam int flightId) {
        FlightRequest newFlightRequest =new FlightRequest();
        newFlightRequest.setPlaceId(placeId);
        newFlightRequest.setFlightId(flightId);
        newFlightRequest.setRequestStatus("PENDING");
        flightRequestRepository.save(newFlightRequest);
        return "redirect:list-flight-requests";
    }

}
