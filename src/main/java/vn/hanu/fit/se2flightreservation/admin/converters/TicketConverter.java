package vn.hanu.fit.se2flightreservation.admin.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.ResponseTicketDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    private AirportConverter airportConverter;

    private FlightClassConverter flightClassConverter;

    public TicketConverter(AirportConverter airportConverter, FlightClassConverter flightClassConverter) {
        this.airportConverter = airportConverter;
        this.flightClassConverter = flightClassConverter;
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
}
