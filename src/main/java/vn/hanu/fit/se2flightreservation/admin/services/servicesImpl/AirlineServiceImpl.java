package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Airline;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.AirlineRepository;
import vn.hanu.fit.se2flightreservation.admin.services.AirlineService;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }


    @Override
    public Airline save(Airline airline) {
        int id = airline.getId();
        if(airlineRepository.existsById(id)){
            throw new EntityExistedByIdException("Airline","Id", id);
        }

        return airlineRepository.save(airline);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline getAirlineById(int id) {
//        Optional<Airline> airline = airlineRepository.findById(id);
//        if(airline.isPresent()){
//            return airline.get();
//        }else {
//            throw new ResourceNotFoundException("Airline","Id",id);
//        }

        return airlineRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airline", "Id", id));
    }

    @Override
    public Airline updateAirline(Airline airline, int id) {
        Airline existingAirline = airlineRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airline","Id",id));

        existingAirline.setImgAPI(airline.getImgAPI());
        existingAirline.setName(airline.getName());
        return airlineRepository.save(existingAirline);
    }

    @Override
    public void deleteAirlineById(int id) {
        Airline existingAirline = airlineRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airline","Id",id));
        airlineRepository.delete(existingAirline);
    }

    @Override
    public void deleteAll() {
        airlineRepository.deleteAll();
    }
}
