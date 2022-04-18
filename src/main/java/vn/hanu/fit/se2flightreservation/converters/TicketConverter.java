package vn.hanu.fit.se2flightreservation.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.dtos.ticket.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    public TicketResponseDto toTicketResponse(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setSeat(ticket.getSeat());
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setCost(ticket.getCost());

        ticketResponseDto.setAirplane(ticket.getAirplane().getCode());

        AirportDto departureAirportDto = new AirportDto();
        departureAirportDto.setCity(ticket.getDepartureAirport().getCity());
        departureAirportDto.setCode(ticket.getDepartureAirport().getCode());
        departureAirportDto.setName(ticket.getDepartureAirport().getName());
        ticketResponseDto.setDepartureAirport(departureAirportDto);

        AirportDto arrivalAirportDto = new AirportDto();
        arrivalAirportDto.setCity(ticket.getArrivalAirport().getCity());
        arrivalAirportDto.setCode(ticket.getArrivalAirport().getCode());
        arrivalAirportDto.setName(ticket.getArrivalAirport().getName());
        ticketResponseDto.setArrivalAirport(arrivalAirportDto);

        Timestamp departureTime = ticket.getDepartureTime();
        String departureDate = new SimpleDateFormat("yyyy-MM-dd").format(departureTime);
        ticketResponseDto.setDepartureDate(departureDate);

        Timestamp arrivalTime = ticket.getArrivalTime();
        String arrivalDate = new SimpleDateFormat("yyyy-MM-dd").format(arrivalTime);
        ticketResponseDto.setArrivalDate(arrivalDate);

        return ticketResponseDto;
    }

    public List<TicketResponseDto> ticketResponseDtoList(List<Ticket> ticketList){
        List<TicketResponseDto> convertedTicketResponseDtoList = new ArrayList<>();
        ticketList.forEach(ticket -> convertedTicketResponseDtoList.add(toTicketResponse(ticket)));
        return convertedTicketResponseDtoList;
    }
}
