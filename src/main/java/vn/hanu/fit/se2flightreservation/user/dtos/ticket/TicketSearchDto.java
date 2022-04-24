package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.enums.ERoundTrip;
import vn.hanu.fit.se2flightreservation.user.dtos.airport.AirportDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketSearchDto implements Serializable {
    private AirportDto departure;

    private AirportDto destination;

    private String ticketClass;

    private Timestamp departureTime;

    private int passengers;
}
