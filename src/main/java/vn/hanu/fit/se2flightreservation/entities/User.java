package vn.hanu.fit.se2flightreservation.entities;

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

    @Column(nullable = false)

    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private String email;

}

