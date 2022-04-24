package vn.hanu.fit.se2flightreservation.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.user.converters.TicketConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.user.services.UTicketService;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/tickets")
public class UTicketController {
    private static final Logger logger = LoggerFactory.getLogger(UTicketController.class);

    private UTicketService ticketService;

    private TicketConverter ticketConverter;

    public UTicketController(UTicketService ticketService, TicketConverter ticketConverter) {
        this.ticketService = ticketService;
        this.ticketConverter = ticketConverter;
    }

    @PostMapping("/search")
    public List<TicketResponseDto> search(@RequestBody TicketSearchDto ticketSearchDto) throws ParseException {
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);
        return ticketConverter.toTicketResponseDtoList(resultTickets);
    }

    @GetMapping("")
    public List<TicketResponseDto> getAll(){
        return ticketConverter.toTicketResponseDtoList(ticketService.getAll());
    }
}
