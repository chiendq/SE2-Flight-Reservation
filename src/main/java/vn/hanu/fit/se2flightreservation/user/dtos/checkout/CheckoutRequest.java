package vn.hanu.fit.se2flightreservation.user.dtos.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.user.dtos.user.UserDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CheckoutRequest {
    private UserDto user;

    @Enumerated(EnumType.STRING)
    private EPaymentMethod paymentMethod;

    private List<Integer> ticketIdList;

    private int passengers;

    private Timestamp createdAt;
}
