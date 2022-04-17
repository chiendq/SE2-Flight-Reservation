package vn.hanu.fit.se2flightreservation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Airline;
import vn.hanu.fit.se2flightreservation.services.AirlineService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {

    private AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        super();
        this.airlineService = airlineService;
    }

    /**
     * Save airline into db
     * @param airline
     * @return ResponseEntity<Airline> with HttpStatus.CREATED
     * @method POST
     */
    @PostMapping("")
    public ResponseEntity<Airline> saveAirLine(@RequestBody Airline airline) {
        return new ResponseEntity<Airline>(airlineService.save(airline), HttpStatus.CREATED);
    }

    /**
     * Get all arirlines
     * @return List<Airline>
     * @method GET
     */
    @GetMapping("")
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    /**
     * Get airline by id
     * @param airlineId
     * @return Airline
     * @method GET
     * @url .../api/v1/airline/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable("id") int airlineId) {
        return new ResponseEntity<Airline>(airlineService.getAirlineById(airlineId), HttpStatus.OK);
    }

    /**
     * update airline with given id
     * @param airline
     * @return airline updated
     * @method PUT
     * @url .../api/v1/airline/1
     */
    @PutMapping("{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable("id") int id, @RequestBody Airline airline) {
        return new ResponseEntity<Airline>(airlineService.updateAirline(airline, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAirline(@PathVariable("id") int id) {
        airlineService.deleteAirlineById(id);
        return new ResponseEntity<String>("Airline deleted successfully!.",HttpStatus.OK);
    }

}
