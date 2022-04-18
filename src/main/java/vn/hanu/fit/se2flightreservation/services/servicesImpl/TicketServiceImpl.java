package vn.hanu.fit.se2flightreservation.services.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.exception.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exception.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.services.TicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);


    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public Ticket save(Ticket ticket) {
        int id = ticket.getId();
        if (ticketRepository.existsById(id)) {
            throw new EntityExistedByIdException("Ticket", "Id", id);
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ticket", "Id", id));
    }

    @Override
    public Ticket updateTicket(Ticket ticket, int id) {
        Ticket existingTicket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket", "Id", id));
        existingTicket.setAirline(ticket.getAirline());
        existingTicket.setCost(ticket.getCost());
        existingTicket.setDepartureAirport(ticket.getDepartureAirport());
        existingTicket.setArrivalAirport(ticket.getArrivalAirport());
        existingTicket.setArrivalTime(ticket.getArrivalTime());
        existingTicket.setDepartureTime(ticket.getDepartureTime());
        existingTicket.setFlightClass(ticket.getFlightClass());
        return ticketRepository.save(existingTicket);
    }

    @Override
    public void deleteTicketById(int id) {
        Ticket existingTicket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket", "Id", id));
        ticketRepository.delete(existingTicket);
    }

    @Override
    public List<Ticket> search(TicketSearchDto ticketSearchDto) {
        List<Ticket> resultTickets = ticketRepository.findAllByArrivalAirport_IdAndDepartureAirport_IdAndFlightClass_Id(
                ticketSearchDto.getArrivalAirportId(),
                ticketSearchDto.getDepartureAirportId(),
                ticketSearchDto.getFlightClassId()
        );

        return filterDate(resultTickets,ticketSearchDto);

    }

    private List<Ticket> filterDate(List<Ticket> resultTickets, TicketSearchDto ticketSearchDto){

        Date departureDate =ticketSearchDto.getDepartureDate();
        List<Ticket> filteredTicket = new ArrayList<>();
        Iterator iterator = resultTickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = (Ticket) iterator.next();
            Date ticketDate = new Date(ticket.getDepartureTime().getTime());
            if(departureDate.getDay() == ticketDate.getDay()
                    && departureDate.getMonth() == ticketDate.getMonth()
                    && departureDate.getYear() == ticketDate.getYear()){
                filteredTicket.add(ticket);
            }
        }
        if (filteredTicket == null || filteredTicket.size() == 0) {
            throw new ResourceNotFoundException("Ticket search", "TicketSearch", ticketSearchDto);
        }
        return filteredTicket;
    }
}
