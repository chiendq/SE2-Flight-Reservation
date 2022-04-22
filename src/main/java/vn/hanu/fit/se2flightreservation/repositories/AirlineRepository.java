package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Airline;

@Repository
public interface AirlineRepository
        extends JpaRepository<Airline, Integer> {

}
