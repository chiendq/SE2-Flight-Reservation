package vn.hanu.fit.se2flightreservation.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Table(name = "bookings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "Booking")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

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

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

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
                '}';
    }
}
