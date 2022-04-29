package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.TicketRepository;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        Integer id = ticket.getId();
        if(id == null) return ticketRepository.save(ticket);
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
    public void deleteAll() {
        ticketRepository.deleteAll();
    }

    @Override
    public List<Ticket> getPageableTickets(int requestPage, int pageSize, String sort) {
        List<Ticket> allTickets = ticketRepository.findAll();

        int totalPage = allTickets.size()/pageSize;
        
        List<Ticket> resultTickets;
        
        if(requestPage < totalPage){
//            if (sort.equals("ASC")) {
//
//            }else if (sort.equals("DESC")) {
//
//            }
            return allTickets.subList(requestPage*pageSize,requestPage*pageSize + pageSize);
        }else if(requestPage == totalPage){
            return allTickets.subList(requestPage*pageSize, allTickets.size()-1);
        }
        return allTickets;
    }

}
