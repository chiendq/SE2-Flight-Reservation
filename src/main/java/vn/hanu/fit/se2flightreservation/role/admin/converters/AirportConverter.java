package vn.hanu.fit.se2flightreservation.role.admin.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.Airport.ResponseAirportDto;
import vn.hanu.fit.se2flightreservation.entities.Airport;

@Component
public class AirportConverter {
    public ResponseAirportDto toResponseAirportDto(Airport airport){
        ResponseAirportDto airportDto = new ResponseAirportDto();
        airportDto.setCity(airport.getCity());
        airportDto.setName(airport.getName());
        airportDto.setCode(airport.getCode());
        return airportDto;
    }
}
