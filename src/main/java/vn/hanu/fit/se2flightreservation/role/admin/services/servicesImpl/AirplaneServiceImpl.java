package vn.hanu.fit.se2flightreservation.role.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Airplane;

import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.AirplaneRepository;
import vn.hanu.fit.se2flightreservation.role.admin.services.AirplaneService;

import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository){
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane getAirplaneById(int id) {
        return airplaneRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airplane", "Id", id));
    }

    @Override
    public Airplane updateAirplane(Airplane airplane, int id) {
        Airplane existingAirplane = airplaneRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airplane","Id",id));
        existingAirplane.setCode(airplane.getCode());
        return airplaneRepository.save(existingAirplane);
    }

    @Override
    public void deleteAirplaneById(int id) {
        Airplane existingAirplane = airplaneRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Airplane","Id",id));
        airplaneRepository.delete(existingAirplane);
    }

    @Override
    public void deleteAll() {
        airplaneRepository.deleteAll();
    }

    @Override
    public Airplane getAirplaneByCode(String code) {
        return airplaneRepository.getAirplaneByCode(code);
    }
}
