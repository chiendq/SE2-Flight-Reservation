package vn.hanu.fit.se2flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.config.AuthEntryPointJwt;
import vn.hanu.fit.se2flightreservation.converter.TicketConverter;
import vn.hanu.fit.se2flightreservation.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.dtos.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.dtos.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.services.TicketService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return new ResponseEntity<String>("Ticket deleted successfully!.", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TicketResponseDto> search(@RequestBody TicketSearchDto ticketSearchDto) throws ParseException {
        logger.info(ticketSearchDto.toString());
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);

        return ticketConverter.ticketResponseDtoList(resultTickets);
    }
}
