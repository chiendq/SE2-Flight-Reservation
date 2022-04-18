package vn.hanu.fit.se2flightreservation.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.FlightClassRepository;
import vn.hanu.fit.se2flightreservation.services.FlightClassService;

import java.util.List;

@Service
public class FlightClassServiceImpl implements FlightClassService {

    private FlightClassRepository flightClassRepository;

    public FlightClassServiceImpl(FlightClassRepository flightClassRepository){
        this.flightClassRepository = flightClassRepository;
    }

    @Override
    public FlightClass save(FlightClass flightClass) {
        int id = flightClass.getId();
        if(flightClassRepository.existsById(id)){
            throw new EntityExistedByIdException("FlightClass","Id", id);
        }
        return flightClassRepository.save(flightClass);
    }

    @Override
    public List<FlightClass> getAllFlightClasss() {
        return flightClassRepository.findAll();
    }

    @Override
    public FlightClass getFlightClassById(int id) {
        return flightClassRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("FlightClass", "Id", id));
    }

    @Override
    public FlightClass updateFlightClass(FlightClass flightClass, int id) {
        FlightClass existingFlightClass = flightClassRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("FlightClass","Id",id));
        existingFlightClass.setName(flightClass.getName());
        existingFlightClass.setDescription(flightClass.getDescription());
        return flightClassRepository.save(existingFlightClass);
    }

    @Override
    public void deleteFlightClassById(int id) {
        FlightClass existingFlightClass = flightClassRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("FlightClass","Id",id));
        flightClassRepository.delete(existingFlightClass);
    }
}
