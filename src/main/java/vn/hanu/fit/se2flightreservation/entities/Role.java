package vn.hanu.fit.se2flightreservation.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.enums.ERole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @Column(nullable = false)
    private String description;

    public Role(ERole name) {
        this.name = name;
    }

    public Role() {

    }
}