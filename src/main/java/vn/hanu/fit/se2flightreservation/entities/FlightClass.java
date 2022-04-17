package vn.hanu.fit.se2flightreservation.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "flight_classes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
