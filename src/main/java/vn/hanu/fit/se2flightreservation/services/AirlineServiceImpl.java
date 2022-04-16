package vn.hanu.fit.se2flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import vn.hanu.fit.se2flightreservation.entity.Airline;
import vn.hanu.fit.se2flightreservation.entity.Airport;
import vn.hanu.fit.se2flightreservation.repository.AirlineRepository;
import vn.hanu.fit.se2flightreservation.repository.AirportRepository;

import java.util.List;

public class AirlineServiceImpl {
    @Autowired
    AirlineRepository airlineRepository;

    public List<Airline> getAll(){
        return airlineRepository.findAll();
    }

    public Airline getById(int id) {
        return airlineRepository.findById(id).get();
    }

}
