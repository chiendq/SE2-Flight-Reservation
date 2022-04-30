package vn.hanu.fit.se2flightreservation.role.admin.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.FlightClass.FlightClassDto;
import vn.hanu.fit.se2flightreservation.entities.FlightClass;

@Component
public class FlightClassConverter {
    public FlightClassDto toFlightClassDto(FlightClass flightClass){
        FlightClassDto flightClassDto= new FlightClassDto();
        flightClassDto.setId(flightClass.getId());
        flightClassDto.setName(flightClass.getName());
        flightClassDto.setDescription(flightClass.getDescription());
        return flightClassDto;
    }
}
