package vn.hanu.fit.se2flightreservation.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.dtos.TicketSearchDto;
import vn.hanu.fit.se2flightreservation.entity.Ticket;
import vn.hanu.fit.se2flightreservation.repository.TicketRepository;

import java.util.List;

@Service
public class TicketServiceImpl {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(int id) {
        return ticketRepository.findById(id).get();
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> search(TicketSearchDto ticketSearchDto) {
        int arrivalAirportId = ticketSearchDto.getArrivalAirportId();
        int departureAirportId = ticketSearchDto.getDepartureAirportId();
        int flightClassId = ticketSearchDto.getFlightClassId();
        return ticketRepository.findAllByArrivalAirport_IdAndDepartureAirport_IdAndFlightClass_Id(arrivalAirportId, departureAirportId, flightClassId);
    }

    public List<Ticket> getByFlightClassId(int flightClassId){

        return ticketRepository.getByFlightClassId(flightClassId);
    }
}
