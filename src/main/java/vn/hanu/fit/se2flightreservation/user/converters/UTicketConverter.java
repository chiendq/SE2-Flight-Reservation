package vn.hanu.fit.se2flightreservation.user.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.user.dtos.ticket.UITicketResponseDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.util.ArrayList;
import java.util.List;

@Component
public class UTicketConverter {
    public UITicketResponseDto toTicketResponse(Ticket ticket){
        UITicketResponseDto ticketResponseDto = new UITicketResponseDto();
        ticketResponseDto.setSeat(ticket.getSeat());
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setPrice(ticket.getCost());
        ticketResponseDto.setTicketClass(ticket.getFlightClass());

        ticketResponseDto.setAirplane(ticket.getAirplane().getCode());

        AirportDto departureAirportDto = new AirportDto();
        departureAirportDto.setCity(ticket.getDepartureAirport().getCity());
        departureAirportDto.setCode(ticket.getDepartureAirport().getCode());
        departureAirportDto.setName(ticket.getDepartureAirport().getName());
        ticketResponseDto.setDeparture(departureAirportDto);

        AirportDto arrivalAirportDto = new AirportDto();
        arrivalAirportDto.setCity(ticket.getArrivalAirport().getCity());
        arrivalAirportDto.setCode(ticket.getArrivalAirport().getCode());
        arrivalAirportDto.setName(ticket.getArrivalAirport().getName());
        ticketResponseDto.setDestination(arrivalAirportDto);

//        Timestamp departureTime = ticket.getDepartureTime();
//        String departureDate = new SimpleDateFormat("yyyy-MM-dd").format(departureTime);

        ticketResponseDto.setDepartureTime(ticket.getDepartureTime().getTime());

//        Timestamp arrivalTime = ticket.getArrivalTime();
//        String arrivalDate = new SimpleDateFormat("yyyy-MM-dd").format(arrivalTime);
        ticketResponseDto.setArrivalTime(ticket.getArrivalTime().getTime());

        return ticketResponseDto;
    }

    public List<UITicketResponseDto> toTicketResponseDtoList(List<Ticket> ticketList){
        List<UITicketResponseDto> convertedTicketResponseDtoList = new ArrayList<>();
        ticketList.forEach(ticket -> convertedTicketResponseDtoList.add(toTicketResponse(ticket)));
        return convertedTicketResponseDtoList;
    }
}