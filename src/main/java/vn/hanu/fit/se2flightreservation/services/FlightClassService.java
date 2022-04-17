package vn.hanu.fit.se2flightreservation.services;

import vn.hanu.fit.se2flightreservation.entity.FlightClass;

import java.util.List;

public interface FlightClassService {

    FlightClass save(FlightClass flightClass);

    List<FlightClass> getAllFlightClasss();

    FlightClass getFlightClassById(int id);

    FlightClass updateFlightClass(FlightClass flightClass, int id);

    void deleteFlightClassById(int id);
}
