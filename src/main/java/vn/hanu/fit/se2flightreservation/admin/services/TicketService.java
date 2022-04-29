package vn.hanu.fit.se2flightreservation.admin.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(int id);

    Ticket updateTicket(Ticket ticket, int id);

    void deleteTicketById(int id);

    void deleteAll();

    List<Ticket> getPageableTickets(int requestPage, int pageSize, String sort);
}
