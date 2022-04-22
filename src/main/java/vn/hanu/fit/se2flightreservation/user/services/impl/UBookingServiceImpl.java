package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.repositories.BookingRepository;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.user.converters.BookingConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
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
            ticketService.saveBooking(savedBooking, ticket.getId());
        });
        return booking;
    }
}
