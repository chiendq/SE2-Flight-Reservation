package vn.hanu.fit.se2flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.converters.TicketConverter;
import vn.hanu.fit.se2flightreservation.dtos.ticket.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.dtos.ticket.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.services.TicketService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    private final TicketConverter ticketConverter;

    public TicketController(TicketService ticketService, TicketConverter ticketConverter) {
        super();
        this.ticketConverter = ticketConverter;
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<TicketResponseDto> saveTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.save(ticket);
        return new ResponseEntity<>(ticketConverter.toTicketResponse(savedTicket), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<TicketResponseDto> getAllTickets() {

        return ticketConverter.ticketResponseDtoList(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable("id") int ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticketConverter.toTicketResponse(ticket), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketConverter.toTicketResponse(ticketService.updateTicket(ticket, id)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") int id) {
        ticketService.deleteTicketById(id);
        return new ResponseEntity<>("Ticket deleted successfully!.", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TicketResponseDto> search(@RequestBody TicketSearchDto ticketSearchDto) throws ParseException {
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);

        return ticketConverter.ticketResponseDtoList(resultTickets);
    }
}
