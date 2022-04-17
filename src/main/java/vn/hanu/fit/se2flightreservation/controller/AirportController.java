package vn.hanu.fit.se2flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entity.Airport;
import vn.hanu.fit.se2flightreservation.servicesImpl.AirportServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {
    @Autowired
    AirportServiceImpl airportService;

    @GetMapping("")
    public List<Airport> getAll(){
        return airportService.getAll();
    }

    @GetMapping(value = {"/{id}"})
    public Airport getById(@PathVariable(value = "id") int id){
        return airportService.getById(id);
    }

//    @PostMapping("")
//    public Airport save(@RequestBody Airport airport){
//        return airportService.save(airport);
//    }

}
