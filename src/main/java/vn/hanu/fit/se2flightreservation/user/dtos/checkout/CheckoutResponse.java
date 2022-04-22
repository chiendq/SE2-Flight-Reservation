package vn.hanu.fit.se2flightreservation.user.dtos.checkout;

import lombok.*;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketResponseDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "CheckoutResponse")
public class CheckoutResponse implements Serializable {
    private String code;

    private Timestamp createdAt;

    private Set<Ticket> tickets;

    @Enumerated(EnumType.STRING)
    private EPaymentMethod paymentMethod;

    private int passengers;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    @Override
    public String toString() {
        return "CheckoutResponse{" +
                "code='" + code + '\'' +
                ", createdAt=" + createdAt +
                ", tickets=" + tickets +
                ", paymentMethod=" + paymentMethod +
                ", passengers=" + passengers +
                ", status=" + status +
                '}';
    }
}
