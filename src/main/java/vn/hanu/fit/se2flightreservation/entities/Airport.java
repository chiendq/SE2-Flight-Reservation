package vn.hanu.fit.se2flightreservation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "airports")
@Entity
public class Airport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

}
