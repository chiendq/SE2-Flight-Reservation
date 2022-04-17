package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.se2flightreservation.entities.Airline;

public interface AirlineRepository
        extends JpaRepository<Airline, Integer> {

}
