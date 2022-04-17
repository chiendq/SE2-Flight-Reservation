package vn.hanu.fit.se2flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.se2flightreservation.entity.Ticket;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TicketRepository
        extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByArrivalAirport_IdAndDepartureAirport_IdAndFlightClass_Id(int arrivalAirportId,
                                                                                      int departureAirportId,
                                                                                      int flightClassId);

    List<Ticket> findAllByDepartureAirport_IdAndArrivalAirport_IdAndFlightClass_IdAndDepartureTime(
            int departureAirportId,
            int arrivalAirportId,
            int flightClassId,
            Timestamp departureTime
            );

//    String search = ;
    @Query(value="SELECT * FROM tickets t where t.flight_class_id= :flightClassId", nativeQuery=true)
    List<Ticket> getByFlightClassId(int flightClassId);
}
