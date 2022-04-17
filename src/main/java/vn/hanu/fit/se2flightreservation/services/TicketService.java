package vn.hanu.fit.se2flightreservation.services;

import vn.hanu.fit.se2flightreservation.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(int id);

    Ticket updateTicket(Ticket ticket, int id);

    void deleteTicketById(int id);
}