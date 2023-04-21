package com.assignment.Flightservice.controller;

import com.assignment.Flightservice.dao.BookingDetailDao;
import com.assignment.Flightservice.model.Booking;
import com.assignment.Flightservice.model.Flight;
import com.assignment.Flightservice.repository.BookingRepository;
import com.assignment.Flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes({"username","id"})
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private FlightRepository flightRepository;


    @GetMapping("book-flight")
    @ResponseBody
    public BookingDetailDao bookFlight(@RequestParam int flightId, @RequestParam String username, ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).get();
        flight.setAvailableForBooking(false);
        Booking newBooking=new Booking();
        newBooking.setFlightId(flightId);
        newBooking.setPlaceId(flight.getPlaceId());
        newBooking.setStatus("booked");
        newBooking.setUsername(username);
        flightRepository.save(flight);
        bookingRepository.save(newBooking);
        String cancelFlightUrl="localhost:8081/cancel-flight?bookingId="+newBooking.getId();
        BookingDetailDao bookingDetailDao=new BookingDetailDao(newBooking,cancelFlightUrl);
        return bookingDetailDao;
    }

    @RequestMapping("cancel-flight")
    public ResponseEntity<Object> cancelFlight(@RequestParam int bookingId, ModelMap modelMap) {
        Optional<Booking> bookingOptional=bookingRepository.findById(bookingId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        if(bookingOptional.isEmpty() || !bookingOptional.get().getUsername().equals((loggedInUsername))) {
            return new ResponseEntity<>("<h1>BAD REQUEST</h1>", HttpStatus.BAD_REQUEST);
        }

        Booking booking=bookingOptional.get();
        Flight flight = flightRepository.findById(booking.getFlightId()).get();
        flight.setAvailableForBooking(true);
        flightRepository.save(flight);
        bookingRepository.deleteById(bookingId);
        return new ResponseEntity<>("<h1>Booking Canceled Successfully</h1>", HttpStatus.OK);
    }
}
