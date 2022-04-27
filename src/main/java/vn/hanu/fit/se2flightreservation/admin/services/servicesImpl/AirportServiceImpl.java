package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Airport;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.AirportRepository;
import vn.hanu.fit.se2flightreservation.admin.services.AirportService;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(int id) {
        return airportRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airport", "Id", id));
    }

    @Override
    public Airport updateAirport(Airport airport, int id) {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airport","Id",id));
        existingAirport.setCity(airport.getCity());
        existingAirport.setCode(airport.getCode());
        existingAirport.setName(airport.getName());
        return airportRepository.save(existingAirport);
    }

    @Override
    public void deleteAirportById(int id) {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airport","Id",id));
        airportRepository.delete(existingAirport);
    }

    @Override
    public void deleteAll() {
        airportRepository.deleteAll();
    }

}
