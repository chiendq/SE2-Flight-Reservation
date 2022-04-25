package vn.hanu.fit.se2flightreservation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = "Booking")
@Entity
@Getter
@Setter
@ToString
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    @JsonIgnore
    private Guest guest;

    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EStatus status;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPaymentMethod paymentMethod;

    @OneToMany(mappedBy = "booking",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonBackReference(value = "tickets")
    private Set<Ticket> tickets;

    private int passengers;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                ", tickets=" + tickets +
                ", passengers=" + passengers +
                '}';
    }
}
