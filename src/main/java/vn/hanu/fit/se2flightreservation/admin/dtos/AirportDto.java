package vn.hanu.fit.se2flightreservation.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportDto {

    private String code;

    private String name;

    private String city;
}
