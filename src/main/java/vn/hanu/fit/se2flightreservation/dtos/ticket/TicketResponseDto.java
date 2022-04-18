package vn.hanu.fit.se2flightreservation.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.entities.Airplane;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketResponseDto {
    private int id;

    private Airplane airplaneDto;

    private AirportDto departureAirportDto;

    private AirportDto arrivalAirportDto;

    private String departureDate;

    private String arrivalDate;

    private int cost;

    private int seat;

}
