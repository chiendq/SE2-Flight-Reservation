package vn.hanu.fit.se2flightreservation.converter;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.dtos.AirportDto;
import vn.hanu.fit.se2flightreservation.dtos.TicketResponseDto;
import vn.hanu.fit.se2flightreservation.entities.Ticket;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    public TicketResponseDto toTicketResponse(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setCost(ticket.getCost());
        ticketResponseDto.setAirplaneName("Airbus");
        ticketResponseDto.setAirplaneImgAPI("");

        ticketResponseDto.setId(ticket.getId());

        AirportDto departureAirportDto = new AirportDto();
        departureAirportDto.setCity(ticket.getDepartureAirport().getCity());
        departureAirportDto.setCode(ticket.getDepartureAirport().getCode());
        departureAirportDto.setName(ticket.getDepartureAirport().getName());

        AirportDto arrivalAirportDto = new AirportDto();
        arrivalAirportDto.setCity(ticket.getArrivalAirport().getCity());
        arrivalAirportDto.setCode(ticket.getArrivalAirport().getCode());
        arrivalAirportDto.setName(ticket.getArrivalAirport().getName());

        ticketResponseDto.setDepartureAirportDto(departureAirportDto);
        ticketResponseDto.setArrivalAirportDto(arrivalAirportDto);

        Timestamp departureTime = ticket.getDepartureTime();
        String departureDate = new SimpleDateFormat("yyyy-MM-dd").format(departureTime);

        ticketResponseDto.setDepartureDate(departureDate);

        Timestamp arrivalTime = ticket.getArrivalTime();
        String arrivalDate = new SimpleDateFormat("yyyy-MM-dd").format(departureTime);

        ticketResponseDto.setArrivalDate(arrivalDate);
        return ticketResponseDto;
    }

    public List<TicketResponseDto> ticketResponseDtoList(List<Ticket> ticketList){
        List<TicketResponseDto> convertedTicketResponseDtoList = new ArrayList<>();
        ticketList.forEach(ticket -> {
            convertedTicketResponseDtoList.add(toTicketResponse(ticket));
        });
        return convertedTicketResponseDtoList;
    }
}
