package vn.hanu.fit.se2flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.dtos.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entity.Ticket;
import vn.hanu.fit.se2flightreservation.servicesImpl.TicketServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;

    @GetMapping("/all")
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }

    @GetMapping(value = {"/{id}"})
    public Ticket getById(@PathVariable(value = "id") int id){
        return ticketService.getById(id);
    }

    @PostMapping("")
    public Ticket save(@RequestBody Ticket ticket){
        return ticketService.save(ticket);
    }

    @GetMapping("/search")
    public List<Ticket> search(@RequestBody TicketSearchDto ticketSearchDto){
        return ticketService.search(ticketSearchDto);
    }

    @GetMapping("/searchbyflightclass/{id}")
    public List<Ticket> search(@PathVariable(value = "id") int id){
        return ticketService.getByFlightClassId(id);
    }
}
