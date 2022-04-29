package vn.hanu.fit.se2flightreservation.admin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.admin.converters.TicketConverter;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.ResponseTicketDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.admin.services.TicketService;

@RestController
@RequestMapping("/api/v1/admin/tickets")
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    private TicketConverter ticketConverter;

    public TicketController(TicketService ticketService, TicketConverter ticketConverter) {
        this.ticketService = ticketService;
        this.ticketConverter = ticketConverter;
    }

    @PostMapping("")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.save(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity<Page<ResponseTicketDto>> getAllTickets(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "50") Integer size,
                                                                 @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Credentials", "true")
                .body(ticketConverter.toResponseTicketDtoPage(ticketService.getPageableTickets(pageable)));
    }

//    @GetMapping("")
//    public ResponseEntity<List<Ticket>> getAllTickets() {
//        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .body(ticketService.getAllTickets());
//    }

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
