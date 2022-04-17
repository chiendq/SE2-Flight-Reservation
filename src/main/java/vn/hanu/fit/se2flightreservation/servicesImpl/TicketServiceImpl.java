package vn.hanu.fit.se2flightreservation.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.exception.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exception.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.services.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        int id = ticket.getId();
        if(ticketRepository.existsById(id)){
            throw new EntityExistedByIdException("Ticket","Id", id);
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
                ()-> new ResourceNotFoundException("Ticket","Id",id));
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
                ()-> new ResourceNotFoundException("Ticket","Id",id));
        ticketRepository.delete(existingTicket);
    }
}
