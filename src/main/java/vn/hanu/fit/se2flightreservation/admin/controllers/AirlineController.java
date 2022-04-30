package vn.hanu.fit.se2flightreservation.admin.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Airline;
import vn.hanu.fit.se2flightreservation.admin.services.AirlineService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/admin/airlines")
public class AirlineController {

    private AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        super();
        this.airlineService = airlineService;
    }

    @PostMapping("")
    public ResponseEntity<Airline> saveAirLine(@RequestBody Airline airline) {
        return new ResponseEntity<Airline>(airlineService.save(airline), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable("id") int airlineId) {
        return new ResponseEntity<Airline>(airlineService.getAirlineById(airlineId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable("id") int id, @RequestBody Airline airline) {
        return new ResponseEntity<Airline>(airlineService.updateAirline(airline, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirline(@PathVariable("id") int id) {
        airlineService.deleteAirlineById(id);
        return new ResponseEntity<String>("Airline deleted successfully!.", HttpStatus.OK);
    }

}
