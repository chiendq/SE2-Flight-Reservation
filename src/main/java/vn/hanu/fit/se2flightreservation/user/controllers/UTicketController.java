package vn.hanu.fit.se2flightreservation.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.user.converters.UTicketConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UITicketResponseDto;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UTicketSearchDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.user.services.UTicketService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class UTicketController {
    private static final Logger logger = LoggerFactory.getLogger(UTicketController.class);

    private UTicketService ticketService;

    private UTicketConverter ticketConverter;

    public UTicketController(UTicketService ticketService, UTicketConverter ticketConverter) {
        this.ticketService = ticketService;
        this.ticketConverter = ticketConverter;
    }

    @PostMapping("/search")
    public List<UITicketResponseDto> search(@RequestBody UTicketSearchDto ticketSearchDto) throws ParseException {
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);
        return ticketConverter.toTicketResponseDtoList(resultTickets);
    }

    @CrossOrigin({"http:localhost:3000"})
    @GetMapping("")
    public ResponseEntity<List<UITicketResponseDto>> getAll(){
        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Credentials", String.valueOf(true))
                .body(ticketConverter.toTicketResponseDtoList(ticketService.getAll()));
    }
}
