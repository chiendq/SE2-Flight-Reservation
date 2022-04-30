package vn.hanu.fit.se2flightreservation.role.admin.dtos.Booking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserBookingDto {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String gender;
}
