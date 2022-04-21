package vn.hanu.fit.se2flightreservation.auth.payload.response;

import lombok.Data;
import vn.hanu.fit.se2flightreservation.enums.EGender;

import java.util.List;

@Data
public class UserInfoResponse {
    private int userId;
    private String username;
    private String email;
    private String fullName;
    private EGender userGender;
    private List<String> roles;

    public UserInfoResponse(int userId, String username, String email, String fullName, EGender gender, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.userGender = gender;
        this.roles = roles;
    }

}
