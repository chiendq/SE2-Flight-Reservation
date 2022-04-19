package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.se2flightreservation.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
