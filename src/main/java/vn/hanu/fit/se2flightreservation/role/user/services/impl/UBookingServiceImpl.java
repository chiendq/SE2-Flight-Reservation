package vn.hanu.fit.se2flightreservation.role.user.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.BookingRepository;
import vn.hanu.fit.se2flightreservation.role.user.services.UTicketService;
import vn.hanu.fit.se2flightreservation.role.user.converters.UBookingConverter;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutRequest;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutResponse;
import vn.hanu.fit.se2flightreservation.role.user.services.UBookingService;

import javax.transaction.Transactional;

@Service
public class UBookingServiceImpl implements UBookingService {
    private UBookingConverter bookingConverter;

    private BookingRepository bookingRepository;

    private UTicketService ticketService;

    public UBookingServiceImpl(UBookingConverter bookingConverter, BookingRepository bookingRepository, UTicketService ticketService) {
        this.bookingConverter = bookingConverter;
        this.bookingRepository = bookingRepository;
        this.ticketService = ticketService;
    }

    @Transactional
    @Override
    public Booking save(UCheckoutRequest checkoutRequest) {
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
    public UCheckoutResponse getBookingByCode(String code) {
        Booking booking = bookingRepository.getBookingByCode(code);
        if(booking == null) throw new ResourceNotFoundException("Booking","code",code);
        return bookingConverter.toCheckoutResponse(booking);
    }
}
