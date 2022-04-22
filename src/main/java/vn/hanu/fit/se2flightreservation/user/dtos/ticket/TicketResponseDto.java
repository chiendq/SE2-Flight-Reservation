package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import lombok.*;
import vn.hanu.fit.se2flightreservation.admin.dtos.AirportDto;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "TicketResponseDto")
public class TicketResponseDto implements Serializable {
    private int id;

    private String airplane;

    private AirportDto departureAirport;

    private AirportDto arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private int price;

    private int seat;

    private String ticketClass;

    @Override
    public String toString() {
        return "TicketResponseDto{" +
                "id=" + id +
                ", airplane='" + airplane + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", seat=" + seat +
                ", ticketClass='" + ticketClass + '\'' +
                '}';
    }
}
