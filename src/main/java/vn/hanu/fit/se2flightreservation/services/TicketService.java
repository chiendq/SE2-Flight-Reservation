package vn.hanu.fit.se2flightreservation.services;

import vn.hanu.fit.se2flightreservation.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.text.ParseException;
import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(int id);

    Ticket updateTicket(Ticket ticket, int id);

    void deleteTicketById(int id);

    List<Ticket> search(TicketSearchDto ticketSearchDto) throws ParseException;
}
