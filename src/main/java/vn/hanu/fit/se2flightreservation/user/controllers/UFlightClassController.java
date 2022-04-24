package vn.hanu.fit.se2flightreservation.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;
import vn.hanu.fit.se2flightreservation.admin.services.FlightClassService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/flightClasses")
public class UFlightClassController {

    private final FlightClassService flightClassService;

    public UFlightClassController(FlightClassService flightClassService) {
        super();
        this.flightClassService = flightClassService;
    }

    @GetMapping("")
    public List<FlightClass> getAllFlightClasss() {
        return flightClassService.getAllFlightClasss();
    }

}