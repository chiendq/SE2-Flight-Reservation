package vn.hanu.fit.se2flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entity.FlightClass;
import vn.hanu.fit.se2flightreservation.servicesImpl.FlightClassServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flightClass")
public class FlightClassController {
    @Autowired
    FlightClassServiceImpl flightClassService;

    @GetMapping("")
    public List<FlightClass> getAll(){
        return flightClassService.getAll();
    }

    @GetMapping(value = {"/{id}"})
    public FlightClass getById(@PathVariable(value = "id") int id){
        return flightClassService.getById(id);
    }

    @PostMapping("")
    public FlightClass save(@RequestBody FlightClass flightClass){
        return flightClassService.save(flightClass);
    }


}
