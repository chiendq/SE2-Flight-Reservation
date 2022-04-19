package vn.hanu.fit.se2flightreservation.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.models.ERole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
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
}