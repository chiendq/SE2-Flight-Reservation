package vn.hanu.fit.se2flightreservation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "airlines")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Airline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String imgAPI;
}
