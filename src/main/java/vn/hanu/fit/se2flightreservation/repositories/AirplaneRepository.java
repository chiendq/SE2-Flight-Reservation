package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Airplane;

@Repository
public interface AirplaneRepository
        extends JpaRepository<Airplane, Integer> {
    Airplane getAirplaneByCode(String code);
}
