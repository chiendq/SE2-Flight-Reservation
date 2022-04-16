package vn.hanu.fit.se2flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entity.FlightClass;
import vn.hanu.fit.se2flightreservation.exception.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repository.FlightClassRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FlightClassServiceImpl {

    @Autowired
    FlightClassRepository flightClassRepository;

    public List<FlightClass> getAll() {
        return flightClassRepository.findAll();
    }

    public FlightClass getById(int id) {
        return flightClassRepository.findById(id).get();
    }

    public FlightClass save(FlightClass flightClass) {
        return flightClassRepository.save(flightClass);
    }

}
