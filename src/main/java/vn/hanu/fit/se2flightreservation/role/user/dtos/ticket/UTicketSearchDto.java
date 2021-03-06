package vn.hanu.fit.se2flightreservation.role.user.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;
import vn.hanu.fit.se2flightreservation.role.user.dtos.airport.UAirportDto;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UTicketSearchDto implements Serializable {
    private UAirportDto departure;

    private UAirportDto destination;

    private FlightClass ticketClass;

    private Timestamp departureTime;

    private int passengers;
}
