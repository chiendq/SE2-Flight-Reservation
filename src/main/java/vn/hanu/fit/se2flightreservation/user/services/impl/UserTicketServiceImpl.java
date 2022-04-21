package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.user.services.UserTicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserTicketServiceImpl implements UserTicketService {

    private final TicketRepository ticketRepository;

    public UserTicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> search(TicketSearchDto ticketSearchDto) {
        List<Ticket> resultTickets = ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Id(
                ticketSearchDto.getDeparture().split("-")[0],
                ticketSearchDto.getDestination().split("-")[0],
                ticketSearchDto.getFlightClassId()
        );
        return filterDate(resultTickets,ticketSearchDto);
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
