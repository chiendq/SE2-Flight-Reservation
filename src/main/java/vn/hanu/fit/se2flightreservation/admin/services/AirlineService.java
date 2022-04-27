package vn.hanu.fit.se2flightreservation.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Airline;

import java.util.List;

public interface AirlineService {
    Airline save(Airline airline);

    List<Airline> getAllAirlines();

    Airline getAirlineById(int id);

    Airline updateAirline(Airline airline, int id);

    void deleteAirlineById(int id);

    void deleteAll();

}
