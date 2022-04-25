package vn.hanu.fit.se2flightreservation.user.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutResponse;
import vn.hanu.fit.se2flightreservation.user.services.UUserService;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Component
public class BookingConverter {
    private TicketService ticketService;

    private UUserService userService;

    private TicketConverter ticketConverter;

    public BookingConverter(TicketService ticketService, UUserService userService, TicketConverter ticketConverter) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.ticketConverter = ticketConverter;
    }

    public Booking fromCheckoutRequest(CheckoutRequest checkoutRequest){
        Booking booking = new Booking();
        Set<Ticket> ticketSet = new HashSet<>();
        checkoutRequest.getTickets().forEach(t->{
            ticketSet.add(ticketService.getTicketById(t.getId()));
        });

        booking.setTickets(ticketSet);
        booking.setCode(String.valueOf(System.currentTimeMillis()).substring(3,13));
        booking.setPassengers(checkoutRequest.getPassengers());
        booking.setStatus(EStatus.STATUS_PENDING);
        EStatus status = EStatus.STATUS_PENDING;
        switch (checkoutRequest.getStatus()){
            case "pending":
                status = EStatus.STATUS_PENDING;
                break;
            case "paid" :
                status = EStatus.STATUS_PAID;
                break;
            case "canceled":
                status = EStatus.STATUS_CANCELED;
                break;
        }
        booking.setStatus(status);

        EPaymentMethod paymentMethod = EPaymentMethod.PAYMENT_CHECKIN;
        switch (checkoutRequest.getPaymentMethod()){
            case "onCheckin":
                paymentMethod = EPaymentMethod.PAYMENT_CHECKIN;
                break;
            case "online":
                paymentMethod = EPaymentMethod.PAYMENT_ONLINE;
        }
        booking.setPaymentMethod(paymentMethod);

        booking.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        int userId = checkoutRequest.getUser().getId();
        if(userId != 0 && userService.isExistById(userId) ){
            booking.setUser(userService.getById(userId));
        }

        return booking;
    }

    public CheckoutResponse toCheckoutResponse(Booking booking){
        CheckoutResponse checkoutResponse = new CheckoutResponse();

        checkoutResponse.setCode(booking.getCode());
        checkoutResponse.setPassengers(booking.getPassengers());
        checkoutResponse.setCreatedAt(booking.getCreatedAt());
        checkoutResponse.setStatus(booking.getStatus());
        checkoutResponse.setPaymentMethod(booking.getPaymentMethod());
//        List<TicketResponseDto> ticketResponseDtos = new ArrayList<>();
//        booking.getTickets().forEach(ticket -> { ticketResponseDtos.add(ticketConverter.toTicketResponse(ticket));});
        checkoutResponse.setTickets(booking.getTickets());

        return checkoutResponse;
    }
}
