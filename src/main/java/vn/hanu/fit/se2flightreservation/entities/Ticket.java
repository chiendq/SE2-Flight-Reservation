package vn.hanu.fit.se2flightreservation.entities;

import lombok.*;
import vn.hanu.fit.se2flightreservation.models.EStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "tickets")
@Entity
@Data
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

    @Column(nullable = false)
    private Timestamp departureTime;

    @Column(nullable = false)
    private Timestamp arrivalTime;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;
}
