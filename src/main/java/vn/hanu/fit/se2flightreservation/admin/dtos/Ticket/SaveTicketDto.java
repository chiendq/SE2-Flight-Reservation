package vn.hanu.fit.se2flightreservation.admin.dtos.Ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveTicketDto {
    private int airlineId;
    private int departureAirportId;
    private int arrivalAirportId;
    private int flightClassId;
    private int airplaneId;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private int cost;
    private EStatus status;
    private int seat;
}
