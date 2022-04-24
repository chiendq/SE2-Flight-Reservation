package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.BookingRepository;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.user.converters.BookingConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutResponse;
import vn.hanu.fit.se2flightreservation.user.services.UBookingService;
import vn.hanu.fit.se2flightreservation.user.services.UTicketService;

import javax.transaction.Transactional;

@Service
public class UBookingServiceImpl implements UBookingService {
    private BookingConverter bookingConverter;

    private BookingRepository bookingRepository;

    private UTicketService ticketService;

    public UBookingServiceImpl(BookingConverter bookingConverter, BookingRepository bookingRepository, UTicketService ticketService) {
        this.bookingConverter = bookingConverter;
        this.bookingRepository = bookingRepository;
        this.ticketService = ticketService;
    }

    @Transactional
    @Override
    public Booking save(CheckoutRequest checkoutRequest) {
        Booking booking = bookingConverter.fromCheckoutRequest(checkoutRequest);
        Booking savedBooking = bookingRepository.save(booking);
        booking.getTickets().forEach(ticket -> {
            int ticketId = ticket.getId();
            if(!ticketService.isAvailable(ticketId)){
                throw new EntityExistedByIdException("Ticket","Status", EStatus.STATUS_PENDING);
            }
            ticketService.saveBooking(savedBooking, ticket.getId());
        });
        return booking;
    }

    @Override
    public CheckoutResponse getBookingByCode(String code) {
        Booking booking = bookingRepository.getBookingByCode(code);
        if(booking == null) throw new ResourceNotFoundException("Booking","code",code);
        return bookingConverter.toCheckoutResponse(booking);
    }
}
