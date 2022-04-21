package vn.hanu.fit.se2flightreservation.admin.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Airplane;
import vn.hanu.fit.se2flightreservation.admin.services.AirplaneService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        super();
        this.airplaneService = airplaneService;
    }

    @PostMapping("")
    public ResponseEntity<Airplane> saveAirplane(@RequestBody Airplane airplane) {
        return new ResponseEntity<Airplane>(airplaneService.save(airplane), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable("id") int airplaneId) {
        return new ResponseEntity<Airplane>(airplaneService.getAirplaneById(airplaneId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable("id") int id, @RequestBody Airplane airplane) {
        return new ResponseEntity<Airplane>(airplaneService.updateAirplane(airplane, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAirplane(@PathVariable("id") int id) {
        airplaneService.deleteAirplaneById(id);
        return new ResponseEntity<>("Airplane deleted successfully!.", HttpStatus.OK);
    }

}
