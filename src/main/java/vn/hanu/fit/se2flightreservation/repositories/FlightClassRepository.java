package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;

@Repository
public interface FlightClassRepository
        extends JpaRepository<FlightClass, Integer> {

}
