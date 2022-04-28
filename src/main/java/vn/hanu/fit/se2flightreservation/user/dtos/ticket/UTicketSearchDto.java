package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.user.dtos.airport.UAirportDto;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UTicketSearchDto implements Serializable {
    private UAirportDto departure;

    private UAirportDto destination;

    private String ticketClass;

    private Timestamp departureTime;

    private int passengers;
}
