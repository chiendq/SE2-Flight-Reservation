package vn.hanu.fit.se2flightreservation.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.dtos.AirportDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketResponseDto {
    private int id;

    private String airplane;

    private AirportDto departureAirport;

    private AirportDto arrivalAirport;

    private String departureDate;

    private String arrivalDate;

    private int cost;

    private int seat;

}
