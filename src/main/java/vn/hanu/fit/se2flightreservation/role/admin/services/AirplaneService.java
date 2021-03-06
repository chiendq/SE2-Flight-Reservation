package vn.hanu.fit.se2flightreservation.role.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Airplane;

import java.util.List;

public interface AirplaneService {
    
    Airplane save(Airplane airplane);

    List<Airplane> getAllAirplanes();

    Airplane getAirplaneById(int id);

    Airplane updateAirplane(Airplane airplane, int id);

    void deleteAirplaneById(int id);

    void deleteAll();

    Airplane getAirplaneByCode(String code);
}
