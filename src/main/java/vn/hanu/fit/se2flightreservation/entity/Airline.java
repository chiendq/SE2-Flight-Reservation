package vn.hanu.fit.se2flightreservation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "airlines")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imgAPI;
}
