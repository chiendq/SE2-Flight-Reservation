package vn.hanu.fit.se2flightreservation.role.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Airport;

import java.util.List;

public interface AirportService {

    Airport save(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(int id);

    Airport updateAirport(Airport airport, int id);

    void deleteAirportById(int id);

    void deleteAll();

    Airport getAirportByCode(String code);
}
