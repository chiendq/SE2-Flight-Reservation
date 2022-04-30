package vn.hanu.fit.se2flightreservation.auth.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class SignupRequest {

    private String fullName;

    private String username;

    private String email;

    private String phone;

    private String gender;

    private Set<String> role;

    private String password;

}