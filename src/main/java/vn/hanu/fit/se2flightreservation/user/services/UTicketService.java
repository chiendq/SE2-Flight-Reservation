package vn.hanu.fit.se2flightreservation.user.services;

import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.text.ParseException;
import java.util.List;

public interface UTicketService {

    List<Ticket> getAll();

    List<Ticket> search(TicketSearchDto ticketSearchDto) throws ParseException;

    boolean saveBooking(Booking booking, int id);

    boolean isAvailable(int ticketId);
}
