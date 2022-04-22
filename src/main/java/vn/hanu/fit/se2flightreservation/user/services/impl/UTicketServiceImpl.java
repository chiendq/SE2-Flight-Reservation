package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.admin.services.BookingService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.user.services.UTicketService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UTicketServiceImpl implements UTicketService {

    private final TicketRepository ticketRepository;

    private final BookingService bookingService;

    public UTicketServiceImpl(TicketRepository ticketRepository, BookingService bookingService) {
        this.ticketRepository = ticketRepository;
        this.bookingService = bookingService;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> search(TicketSearchDto ticketSearchDto) {
        List<Ticket> resultTickets = ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_IdAndBooking(
                ticketSearchDto.getDeparture().split("-")[0],
                ticketSearchDto.getDestination().split("-")[0],
                ticketSearchDto.getFlightClassId(),
                null
        );
        return filterDate(resultTickets,ticketSearchDto);
    }

    @Override
    public boolean saveBooking(Booking booking, int ticketId){

        return ticketRepository.setBooking(booking, ticketId) > 0;
    }


    private List<Ticket> filterDate(List<Ticket> resultTickets, TicketSearchDto ticketSearchDto){

        Date departureDate =ticketSearchDto.getDepartureDate();
        List<Ticket> filteredTicket = new ArrayList<>();
        for (Ticket ticket : resultTickets) {
            Date ticketDate = new Date(ticket.getDepartureTime().getTime());
            if (departureDate.getDay() == ticketDate.getDay()
                    && departureDate.getMonth() == ticketDate.getMonth()
                    && departureDate.getYear() == ticketDate.getYear()) {
                filteredTicket.add(ticket);
            }
        }
        if (filteredTicket.size() == 0) {
            throw new ResourceNotFoundException("Ticket search", "TicketSearch", ticketSearchDto);
        }
        return filteredTicket;
    }
}
