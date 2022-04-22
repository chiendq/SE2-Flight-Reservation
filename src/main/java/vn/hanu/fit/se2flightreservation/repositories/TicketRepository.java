package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Id(String departureCode,
                                                                                       String arrivalCode,
                                                                                       int flightClassId);

    @Modifying
    @Query("UPDATE Ticket t SET t.booking =?1 WHERE t.id = ?2")
    int setBooking(Booking booking, int ticketId);

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_IdAndBooking(String departureCode,
                                                                                                  String arrivalCode,
                                                                                                  int flightClassId,
                                                                                                  Booking booking);
}
