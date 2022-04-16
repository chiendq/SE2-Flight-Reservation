package vn.hanu.fit.se2flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.se2flightreservation.entity.FlightClass;

import java.util.Optional;

public interface FlightClassRepository
        extends JpaRepository<FlightClass, Integer> {

}
