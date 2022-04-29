package vn.hanu.fit.se2flightreservation.user.services;

import org.springframework.data.domain.Page;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UTicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.text.ParseException;
import java.util.List;

public interface UTicketService {

    List<Ticket> getAll();

    List<Ticket> search(UTicketSearchDto ticketSearchDto) throws ParseException;

    boolean saveBooking(Booking booking, int id);

    boolean isAvailable(int ticketId);

    Page<Ticket> getPageableTickets();

    List<Ticket> getPageableTickets(Integer page, Integer size, String sort);
}
