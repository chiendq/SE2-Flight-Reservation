package vn.hanu.fit.se2flightreservation.admin.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Airport;
import vn.hanu.fit.se2flightreservation.admin.services.AirportService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/airports")
public class AirportController {
    
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        super();
        this.airportService = airportService;
    }

    @PostMapping("")
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport) {
        return new ResponseEntity<>(airportService.save(airport), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") int airportId) {
        return new ResponseEntity<>(airportService.getAirportById(airportId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") int id, @RequestBody Airport airport) {
        return new ResponseEntity<>(airportService.updateAirport(airport, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable("id") int id) {
        airportService.deleteAirportById(id);
        return new ResponseEntity<String>("Airport deleted successfully!.",HttpStatus.OK);
    }

}
