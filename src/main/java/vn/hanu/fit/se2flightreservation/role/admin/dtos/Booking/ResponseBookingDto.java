package vn.hanu.fit.se2flightreservation.role.admin.dtos.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.Ticket.ResponseTicketDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBookingDto {
    private int id;
    private String status;
    private long createdAt;
    private int passengers;
    private UserBookingDto user;
    private String paymentMethod;
    private List<ResponseTicketDto> tickets;
}
