package vn.hanu.fit.se2flightreservation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guests")
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private EGender gender;

    public Guest(String fullName, String phoneNumber, EGender gender) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
