package vn.hanu.fit.se2flightreservation.admin.converters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.ResponseTicketDto;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.SaveTicketDto;
import vn.hanu.fit.se2flightreservation.admin.services.AirlineService;
import vn.hanu.fit.se2flightreservation.admin.services.AirplaneService;
import vn.hanu.fit.se2flightreservation.admin.services.AirportService;
import vn.hanu.fit.se2flightreservation.admin.services.FlightClassService;
import vn.hanu.fit.se2flightreservation.entities.Airplane;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    private AirportConverter airportConverter;

    private FlightClassConverter flightClassConverter;

    private AirlineService airlineService;

    private AirportService airportService;

    private FlightClassService flightClassService;

    private AirplaneService airplaneService;

    public TicketConverter(AirportConverter airportConverter, FlightClassConverter flightClassConverter, AirlineService airlineService, AirportService airportService, FlightClassService flightClassService, AirplaneService airplaneService) {
        this.airportConverter = airportConverter;
        this.flightClassConverter = flightClassConverter;
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.flightClassService = flightClassService;
        this.airplaneService = airplaneService;
    }

    public ResponseTicketDto toResponseTicketDto(Ticket ticket){
        ResponseTicketDto responseTicketDto = new ResponseTicketDto();
        responseTicketDto.setId(ticket.getId());

        responseTicketDto.setDestination(airportConverter.toResponseAirportDto(ticket.getArrivalAirport()));
        responseTicketDto.setDeparture(airportConverter.toResponseAirportDto(ticket.getDepartureAirport()));
        responseTicketDto.setDepartureTime(ticket.getDepartureTime().getTime());
        responseTicketDto.setArrivalTime(ticket.getArrivalTime().getTime());
        responseTicketDto.setPrice(ticket.getCost());
        responseTicketDto.setSeat(ticket.getSeat());
        responseTicketDto.setTicketClass(flightClassConverter.toFlightClassDto(ticket.getFlightClass()));

        String status = "";
        switch (ticket.getStatus()){
            case STATUS_AVAILABLE:
                status = "avaiable";
                break;
            case STATUS_PENDING:
                status = "pending";
                break;
            case STATUS_PAID:
                status = "sold";
                break;
        }
        responseTicketDto.setStatus(status);
        responseTicketDto.setAirplane(ticket.getAirplane().getCode());
        return responseTicketDto;
    }

    public List<ResponseTicketDto> toResponseTicketDtoList(List<Ticket> tickets){
        List<ResponseTicketDto> responseTicketDtoList = new ArrayList<>();
        for (Ticket ticket: tickets
             ) {
            responseTicketDtoList.add(toResponseTicketDto(ticket));
        }
        return responseTicketDtoList;
    }

    public Page<ResponseTicketDto> toResponseTicketDtoPage(Page<Ticket> ticketPage){
        Page<ResponseTicketDto> responseTicketDtoPage = ticketPage.map( ticket -> {
            return toResponseTicketDto(ticket);
        });
        return responseTicketDtoPage;
    }

    public Ticket fromDtoToTicket(SaveTicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setAirline(airlineService.getAirlineById(ticketDto.getAirlineId()));
        ticket.setDepartureAirport(airportService.getAirportById(ticketDto.getDepartureAirportId()));
        ticket.setArrivalAirport(airportService.getAirportById(ticketDto.getArrivalAirportId()));
        ticket.setFlightClass(flightClassService.getFlightClassById(ticketDto.getFlightClassId()));
        ticket.setAirplane(airplaneService.getAirplaneById(ticketDto.getAirplaneId()));
        ticket.setDepartureTime(ticketDto.getDepartureTime());
        ticket.setArrivalTime(ticketDto.getArrivalTime());
        ticket.setCost(ticketDto.getCost());
        ticket.setStatus(ticketDto.getStatus());
        ticket.setSeat(ticketDto.getSeat());
        ticket.setBooking(null);
        return ticket;
    }
}
