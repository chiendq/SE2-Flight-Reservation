package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import lombok.*;
import vn.hanu.fit.se2flightreservation.admin.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "TicketResponseDto")
public class UITicketResponseDto implements Serializable {
    private int id;

    private String airplane;

    private AirportDto departure;

    private AirportDto destination;

    private long departureTime;

    private long arrivalTime;

    private int price;

    private int seat;

    private FlightClass ticketClass;

    @Override
    public String toString() {
        return "TicketResponseDto{" +
                "id=" + id +
                ", airplane='" + airplane + '\'' +
                ", departure=" + departure +
                ", destination=" + destination +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", seat=" + seat +
                ", ticketClass='" + ticketClass + '\'' +
                '}';
    }
}
