package vn.hanu.fit.se2flightreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "tickets")
@Entity
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

    private Timestamp departureTime;

    private Timestamp arrivalTime;

    private Integer cost;
}
