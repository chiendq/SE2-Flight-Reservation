package vn.hanu.fit.se2flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entity.Airport;
import vn.hanu.fit.se2flightreservation.repository.AirportRepository;

import java.util.List;

@Service
public class AirportServiceImpl {
    @Autowired
    AirportRepository airportRepository;

    public List<Airport> getAll(){
        return airportRepository.findAll();
    }

    public Airport getById(int id) {
        return airportRepository.findById(id).get();
    }

    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

}
