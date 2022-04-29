package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Airport;

@Repository
public interface AirportRepository
        extends JpaRepository<Airport, Integer> {
    Airport getAirportByCode(String code);
}
