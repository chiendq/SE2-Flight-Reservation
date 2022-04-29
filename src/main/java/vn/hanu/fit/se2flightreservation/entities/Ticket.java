package vn.hanu.fit.se2flightreservation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "tickets")
@Entity
//@EqualsAndHashCode(exclude = "Ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arrivalAirport;

    @ManyToOne
    private FlightClass flightClass;

    @ManyToOne
    private Airplane airplane;

    @Column(nullable = false)
    private Timestamp departureTime;

    @Column(nullable = false)
    private Timestamp arrivalTime;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;

    private int seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    @JsonManagedReference(value = "booking_id")
    private Booking booking;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", airline=" + airline +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", flightClass=" + flightClass +
                ", airplane=" + airplane +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", cost=" + cost +
                ", status=" + status +
                ", seat=" + seat +
                ", booking=" + booking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return seat == ticket.seat && Objects.equals(id, ticket.id) && Objects.equals(airline, ticket.airline) && Objects.equals(departureAirport, ticket.departureAirport) && Objects.equals(arrivalAirport, ticket.arrivalAirport) && Objects.equals(flightClass, ticket.flightClass) && Objects.equals(airplane, ticket.airplane) && Objects.equals(departureTime, ticket.departureTime) && Objects.equals(arrivalTime, ticket.arrivalTime) && Objects.equals(cost, ticket.cost) && status == ticket.status && Objects.equals(booking, ticket.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airline, departureAirport, arrivalAirport, flightClass, airplane, departureTime, arrivalTime, cost, status, seat, booking);
    }

    public Ticket(Airline airline, Airport departureAirport, Airport arrivalAirport, FlightClass flightClass, Airplane airplane, Timestamp departureTime, Timestamp arrivalTime, Integer cost, EStatus status, int seat, Booking booking) {
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightClass = flightClass;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cost = cost;
        this.status = status;
        this.seat = seat;
        this.booking = booking;
    }
}
