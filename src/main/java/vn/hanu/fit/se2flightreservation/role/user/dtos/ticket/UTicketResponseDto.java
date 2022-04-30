package vn.hanu.fit.se2flightreservation.role.user.dtos.ticket;

import lombok.*;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "TicketResponseDto")
public class UTicketResponseDto implements Serializable {
    private int id;
    private AirportDto destination;
    private AirportDto departure;
    private long departureTime;
    private int price;
    private int seat;
    private FlightClass ticketClass;
    private long arrivalTime;
    private String airplane;

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
