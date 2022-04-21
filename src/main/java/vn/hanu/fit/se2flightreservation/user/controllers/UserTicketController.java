package vn.hanu.fit.se2flightreservation.user.controllers;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.converters.TicketConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.user.services.UserTicketService;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/tickets")
public class UserTicketController {
    private static final Logger logger = LoggerFactory.getLogger(UserTicketController.class);

    private UserTicketService ticketService;

    private TicketConverter ticketConverter;

    public UserTicketController(UserTicketService ticketService, TicketConverter ticketConverter) {
        this.ticketService = ticketService;
        this.ticketConverter = ticketConverter;
    }

    @GetMapping("/search")
    public List<TicketResponseDto> search(@RequestBody TicketSearchDto ticketSearchDto) throws ParseException {
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);
        return ticketConverter.toTicketResponseDtoList(resultTickets);
    }

    @GetMapping("")
    public List<TicketResponseDto> getAll(){
        return ticketConverter.toTicketResponseDtoList(ticketService.getAll());
    }
}
