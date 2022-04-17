package vn.hanu.fit.se2flightreservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entity.Ticket;
import vn.hanu.fit.se2flightreservation.services.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        super();
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        return new ResponseEntity<Ticket>(ticketService.save(ticket), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int ticketId) {
        return new ResponseEntity<Ticket>(ticketService.getTicketById(ticketId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
        return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") int id) {
        ticketService.deleteTicketById(id);
        return new ResponseEntity<String>("Ticket deleted successfully!.",HttpStatus.OK);
    }

}
