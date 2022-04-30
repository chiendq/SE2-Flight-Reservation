package vn.hanu.fit.se2flightreservation.role.admin.dtos.Ticket;

import lombok.Getter;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.Airport.ResponseAirportDto;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.FlightClass.FlightClassDto;

@Getter
@Setter
public class ResponseTicketDto {
    private int id;
    private ResponseAirportDto destination;
    private ResponseAirportDto departure;
    private long departureTime;
    private long arrivalTime;
    private int price;
    private int seat;
    private FlightClassDto ticketClass;
    private String status;
    private String airplane;
}
