package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Id(String departureCode,
                                                                                       String arrivalCode,
                                                                                       int flightClassId);

    @Modifying
    @Query("UPDATE Ticket t SET t.booking =?1, t.status=?2 WHERE t.id = ?3")
    int setBooking(Booking booking,EStatus eStatus, int ticketId);

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClassAndBooking(String departureCode,
                                                                                                  String arrivalCode,
                                                                                                  int flightClassId,
                                                                                                  Booking booking);

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Name(String departureCode,
                                                                                         String arrivalCode,
                                                                                         String flightClass);
    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass(String departureCode,
                                                                                         String arrivalCode,
                                                                                         FlightClass flightClass);

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_Code(String departureCode,String arrivalCode);
    List<Ticket> findAllByDepartureAirport_Code(String departureCode);
    List<Ticket> findAllByBooking(Booking booking);

    @Query("SELECT t FROM Ticket t")
    Page<Ticket> getPageableTicket(Pageable pageable);


}
