package vn.hanu.fit.se2flightreservation.entities;

import lombok.Data;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Table(name = "bookings")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EStatus status;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPaymentMethod paymentMethod;

    @OneToMany(mappedBy = "booking")
    private Set<Ticket> tickets;


}
