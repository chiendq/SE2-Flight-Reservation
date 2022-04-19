package vn.hanu.fit.se2flightreservation.payload.request;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
public class SignupRequest {

    private String fullName;

    private String username;

    private String email;

    private String phone;

    private String gender;

    private Set<String> role;

    private String password;

}