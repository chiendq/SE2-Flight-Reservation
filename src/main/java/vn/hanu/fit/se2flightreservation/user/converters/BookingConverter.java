package vn.hanu.fit.se2flightreservation.user.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;
import vn.hanu.fit.se2flightreservation.admin.services.UserService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.services.UUserService;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Component
public class BookingConverter {
    private TicketService ticketService;

    private UUserService userService;

    public BookingConverter(TicketService ticketService, UUserService uUserService) {
        this.ticketService = ticketService;
        this.userService = uUserService;
    }

    public Booking fromCheckoutRequest(CheckoutRequest checkoutRequest){
        Booking booking = new Booking();
        Set<Ticket> ticketSet = new HashSet<>();
        checkoutRequest.getTicketIdList().forEach(id->{
            ticketSet.add(ticketService.getTicketById(id));
        });

        booking.setTickets(ticketSet);
        booking.setCode("OKEYYY");
        booking.setStatus(EStatus.STATUS_PENDING);
        booking.setPaymentMethod(EPaymentMethod.PAYMENT_CHECKIN);
        booking.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        int userId = checkoutRequest.getUser().getUserId();
        if(userId != 0 && userService.isExistById(userId) ){
            booking.setUser(userService.getById(userId));
        }

        return booking;
    }
}
