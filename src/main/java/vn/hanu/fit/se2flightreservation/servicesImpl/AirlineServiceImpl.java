package vn.hanu.fit.se2flightreservation.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Airline;
import vn.hanu.fit.se2flightreservation.exception.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exception.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.AirlineRepository;
import vn.hanu.fit.se2flightreservation.services.AirlineService;

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

    /**
     * Update airline information
     *      if airline with given id is existed :
     *          - Yes : throw ResourceNotFoundException
     *          - No : save
     * @param airline
     * @param id
     * @return
     */
    @Override
    public Airline updateAirline(Airline airline, int id) {
        Airline existingAirline = airlineRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airline","Id",id));

        existingAirline.setImgAPI(airline.getImgAPI());
        existingAirline.setName(airline.getName());
        return airlineRepository.save(existingAirline);
    }

    /**
     * Delete airline with given id.
     *     If airline with given id is existed :
     *          + Yes : delete.
     *          + No : throw exception
     * @param id
     * @exception ResourceNotFoundException
     * @return
     */
    @Override
    public void deleteAirlineById(int id) {
        Airline existingAirline = airlineRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airline","Id",id));
        airlineRepository.delete(existingAirline);
    }


}
