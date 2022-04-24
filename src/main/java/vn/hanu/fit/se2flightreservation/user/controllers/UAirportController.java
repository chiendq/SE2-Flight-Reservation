package vn.hanu.fit.se2flightreservation.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.admin.services.AirportService;
import vn.hanu.fit.se2flightreservation.entities.Airport;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/airports")
public class UAirportController {

    private final AirportService airportService;

    public UAirportController(AirportService airportService) {
        super();
        this.airportService = airportService;
    }

    @GetMapping("")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

}