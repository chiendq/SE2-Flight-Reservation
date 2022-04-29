package vn.hanu.fit.se2flightreservation.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.TicketPaginationDto;
import vn.hanu.fit.se2flightreservation.user.converters.UTicketConverter;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UTicketPaginationDto;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UTicketResponseDto;
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
    public List<UTicketResponseDto> search(@RequestBody UTicketSearchDto ticketSearchDto) throws ParseException {
        List<Ticket> resultTickets = ticketService.search(ticketSearchDto);
        return ticketConverter.toTicketResponseDtoList(resultTickets);
    }

    @CrossOrigin({"http:localhost:3000"})
    @GetMapping("")
    public ResponseEntity<UTicketPaginationDto> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                       @RequestParam(name = "size", required = false, defaultValue = "50") Integer size,
                                                       @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort){
        UTicketPaginationDto ticketPaginationDto = new UTicketPaginationDto();
        ticketPaginationDto.setItems(ticketConverter.toTicketResponseDtoList(ticketService.getPageableTickets(page, size, sort)));
        int totalElement = ticketService.getAll().size();
        ticketPaginationDto.setTotalPage(totalElement/ size);
        ticketPaginationDto.setTotalElements(totalElement);
        return ResponseEntity.ok()
                .body(ticketPaginationDto);
    }
}
