package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking getBookingByCode(String code);

//    @Query("SELECT Booking from Booking WHERE code = ?1")
//    Booking getBookingByCode(String code);
}
