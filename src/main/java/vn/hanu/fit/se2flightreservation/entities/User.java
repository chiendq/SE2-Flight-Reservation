package vn.hanu.fit.se2flightreservation.entities;

import lombok.*;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude = "User")
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private String fullname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private EGender gender;

    @Column(nullable = false)
    private String email;

    public User(Set<Role> roles, String fullname, String username, String password, String phone, EGender gender, String email) {
        this.roles = roles;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roles=" + roles +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}

