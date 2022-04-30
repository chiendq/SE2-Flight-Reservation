package vn.hanu.fit.se2flightreservation.role.user.dtos.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import vn.hanu.fit.se2flightreservation.role.user.dtos.ticket.UTicketDto;
import vn.hanu.fit.se2flightreservation.role.user.dtos.user.UUserDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UCheckoutRequest implements Serializable {
    private UUserDto user;

    private String status;

    private String paymentMethod;

    private int passengers;

    private Timestamp createdAt;

    private List<UTicketDto> tickets;

}
