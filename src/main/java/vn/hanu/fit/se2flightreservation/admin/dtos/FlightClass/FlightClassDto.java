package vn.hanu.fit.se2flightreservation.admin.dtos.FlightClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightClassDto {
    private int id;
    private String name;
    private String description;
}
