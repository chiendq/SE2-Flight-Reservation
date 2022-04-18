package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository
        extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByArrivalAirport_IdAndDepartureAirport_IdAndFlightClass_Id(int arrivalAirportId,
                                                                                   int departureAirportId,
                                                                                   int flightClassI);
//
//
//    @Query(value="SELECT * FROM tickets where" +
//            " flight_class_id= :flightClassId" +
//            "AND arrival_airport_id = :arrivalAirportId " +
//            "AND departure_airport_id = :departureAirportId" +
//            "", nativeQuery=true)
//    List<Ticket> search(int flightClassId, int arrivalAirportId, int departureAirportId );

}
