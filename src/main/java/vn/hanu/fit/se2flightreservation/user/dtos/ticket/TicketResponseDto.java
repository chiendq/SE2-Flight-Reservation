package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.admin.dtos.AirportDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketResponseDto {
    private int id;

    private String airplane;

    private AirportDto departureAirport;

    private AirportDto arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private int price;

    private int seat;

    private String ticketClass;
}
