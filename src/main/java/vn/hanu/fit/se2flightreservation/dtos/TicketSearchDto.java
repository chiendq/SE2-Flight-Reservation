package vn.hanu.fit.se2flightreservation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketSearchDto {
    private int departureAirportId;

    private int arrivalAirportId;

    private int flightClassId;
}
