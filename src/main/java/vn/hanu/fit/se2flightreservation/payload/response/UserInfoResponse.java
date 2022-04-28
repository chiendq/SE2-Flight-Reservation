package vn.hanu.fit.se2flightreservation.payload.response;

import lombok.Data;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import java.util.List;

@Data
public class UserInfoResponse {
    private int userId;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String token;
    private EGender userGender;
    private List<String> roles;


    public UserInfoResponse(int userId, String username, String email, String fullName, String phoneNumber, String token, EGender userGender, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.userGender = userGender;
        this.roles = roles;
    }
}
