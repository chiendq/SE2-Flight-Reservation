package vn.hanu.fit.se2flightreservation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketResponseDto {
    private int id;

    private String airplaneName;

    private String airplaneImgAPI;

    private AirportDto departureAirportDto;

    private AirportDto arrivalAirportDto;

    private String departureDate;

    private String arrivalDate;

    private int cost;

}
