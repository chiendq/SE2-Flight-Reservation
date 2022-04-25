package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.admin.services.BookingService;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.enums.EStatus;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.user.services.UTicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UTicketServiceImpl implements UTicketService {
    private static final Logger logger = LoggerFactory.getLogger(UTicketServiceImpl.class);

    private final TicketRepository ticketRepository;

    private final BookingService bookingService;

    public UTicketServiceImpl(TicketRepository ticketRepository, BookingService bookingService) {
        this.ticketRepository = ticketRepository;
        this.bookingService = bookingService;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAllByBooking(null);
    }

    @Override
    public List<Ticket> search(TicketSearchDto ticketSearchDto) {
        if(ticketSearchDto.getTicketClass() == null){
            List<Ticket> resultTickets = ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_Code(
                    ticketSearchDto.getDeparture().getCode(),
                    ticketSearchDto.getDestination().getCode()
            );
            return filterAvailable(filterDate(resultTickets, ticketSearchDto));
        }
        List<Ticket> resultTickets = ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Name(
                ticketSearchDto.getDeparture().getCode(),
                ticketSearchDto.getDestination().getCode(),
                ticketSearchDto.getTicketClass()
        );
        return filterAvailable(filterDate(resultTickets, ticketSearchDto));
    }

    @Override
    public boolean saveBooking(Booking booking, int ticketId) {

        return ticketRepository.setBooking(booking, booking.getStatus(), ticketId) > 0;
    }

    @Override
    public boolean isAvailable(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", ticketId));
//        System.out.println("ID : " + ticketId + ", is avaiable: " + ticket.getStatus().equals(EStatus.STATUS_AVAILABLE));
        return ticket.getStatus().equals(EStatus.STATUS_AVAILABLE);
    }

    private List<Ticket> filterAvailable(List<Ticket> resultTickets){
        List<Ticket> filteredTicket = new ArrayList<>();
        for (Ticket ticket : resultTickets) {
            if (ticket.getStatus() == EStatus.STATUS_AVAILABLE) {
                filteredTicket.add(ticket);
            }
        }
        return filteredTicket;
    }

    private List<Ticket> filterDate(List<Ticket> resultTickets, TicketSearchDto ticketSearchDto) {
        Date requestDate = ticketSearchDto.getDepartureTime();

        List<Ticket> filteredTicket = new ArrayList<>();
        for (Ticket ticket : resultTickets) {
            Date ticketDate = new Date(ticket.getDepartureTime().getTime());
            if (ticketDate.getDay() == requestDate.getDay() &&
                    ticketDate.getMonth() == requestDate.getMonth() &&
                    ticketDate.getYear() == requestDate.getYear()) {
                filteredTicket.add(ticket);
            }
        }

        if (filteredTicket.size() < ticketSearchDto.getPassengers()) {
            throw new ResourceNotFoundException("Ticket search", "TicketSearch", ticketSearchDto);
        }
        return filteredTicket;
    }
}
