package vn.hanu.fit.se2flightreservation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Role role;

    private String fullName;

    private String username;

    private String password;

    private String phone;

    private boolean gender;

    private String email;

}

