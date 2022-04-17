package vn.hanu.fit.se2flightreservation.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entity.Airline;
import vn.hanu.fit.se2flightreservation.entity.Airport;
import vn.hanu.fit.se2flightreservation.exception.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exception.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repository.AirportRepository;
import vn.hanu.fit.se2flightreservation.services.AirportService;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport save(Airport airport) {
        int id = airport.getId();
        if(isPresent(id)!= null){
            throw new EntityExistedByIdException("Airline","Id", id);
        }
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
        Airport existingAirport = isPresent(id);
        existingAirport.setCity(airport.getCity());
        existingAirport.setCode(airport.getCode());
        existingAirport.setName(airport.getName());
        return airportRepository.save(existingAirport);
    }

    @Override
    public void deleteAirportById(int id) {
        Airport existingAirport = isPresent(id);
        airportRepository.delete(existingAirport);
    }

    @Override
    public Airport isPresent(int id) {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airline","Id",id));
        return existingAirport;
    }
}
