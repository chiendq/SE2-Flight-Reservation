package vn.hanu.fit.se2flightreservation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;
import vn.hanu.fit.se2flightreservation.services.FlightClassService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flightClass")
public class FlightClassController {

    private FlightClassService flightClassService;

    public FlightClassController(FlightClassService flightClassService) {
        super();
        this.flightClassService = flightClassService;
    }

    @PostMapping("")
    public ResponseEntity<FlightClass> saveFlightClass(@RequestBody FlightClass flightClass) {
        return new ResponseEntity<FlightClass>(flightClassService.save(flightClass), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<FlightClass> getAllFlightClasss() {
        return flightClassService.getAllFlightClasss();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightClass> getFlightClassById(@PathVariable("id") int flightClassId) {
        return new ResponseEntity<FlightClass>(flightClassService.getFlightClassById(flightClassId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlightClass> updateFlightClass(@PathVariable("id") int id, @RequestBody FlightClass flightClass) {
        return new ResponseEntity<FlightClass>(flightClassService.updateFlightClass(flightClass, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlightClass(@PathVariable("id") int id) {
        flightClassService.deleteFlightClassById(id);
        return new ResponseEntity<String>("FlightClass deleted successfully!.",HttpStatus.OK);
    }

}
