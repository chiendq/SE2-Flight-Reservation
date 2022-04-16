package vn.hanu.fit.se2flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entity.Airport;

@Repository
public interface AirportRepository
        extends JpaRepository<Airport, Integer> {
}
