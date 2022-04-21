package vn.hanu.fit.se2flightreservation.admin.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/admin/ticket")
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        super();
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.save(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("")
    @JsonFormat
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.updateTicket(ticket, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") int id) {
        ticketService.deleteTicketById(id);
        return new ResponseEntity<>("Ticket deleted successfully!.", HttpStatus.OK);
    }

}
