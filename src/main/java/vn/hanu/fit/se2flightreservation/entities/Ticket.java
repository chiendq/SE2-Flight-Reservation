package vn.hanu.fit.se2flightreservation.entities;

import lombok.*;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "tickets")
@Entity
@EqualsAndHashCode(exclude = "Ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "booking_id")
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
}
