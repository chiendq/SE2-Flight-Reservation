package vn.hanu.fit.se2flightreservation.admin.dtos.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.se2flightreservation.entities.Booking;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto implements Serializable {
    private int id;
    private List<Booking> purchasedHistories;
    private String email;
    private String phoneNumber;
    private String fullName;
    private String username;
    private String password;
    private String gender;
    private long createdAt;
}
