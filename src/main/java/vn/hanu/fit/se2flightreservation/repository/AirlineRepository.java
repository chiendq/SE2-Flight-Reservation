package vn.hanu.fit.se2flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.se2flightreservation.entity.Airline;

public interface AirlineRepository
        extends JpaRepository<Airline, Integer> {

}
