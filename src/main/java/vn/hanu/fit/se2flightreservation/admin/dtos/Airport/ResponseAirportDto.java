package vn.hanu.fit.se2flightreservation.admin.dtos.Airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirportDto {
    private String code;
    private String name;
    private String city;
}
