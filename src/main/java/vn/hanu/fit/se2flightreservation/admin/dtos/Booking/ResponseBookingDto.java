package vn.hanu.fit.se2flightreservation.admin.dtos.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.ResponseTicketDto;
import vn.hanu.fit.se2flightreservation.admin.dtos.User.ResponseUserDto;
import vn.hanu.fit.se2flightreservation.entities.Booking;

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
