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
    private String departure;
    private String destination;
    private int price;
    private String ticketClass;
    private int seat;
    private String airplane;
    private Timestamp departureTime;
    private Timestamp destinationTime;
}
