package vn.hanu.fit.se2flightreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "flight_classes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;
}
