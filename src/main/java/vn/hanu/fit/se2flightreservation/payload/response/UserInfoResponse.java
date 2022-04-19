package vn.hanu.fit.se2flightreservation.payload.response;

import vn.hanu.fit.se2flightreservation.models.EGender;

import java.util.List;

public class UserInfoResponse {
    private int id;
    private String username;
    private String email;
    private EGender gender;
    private List<String> roles;

    public UserInfoResponse(int id, String username, String email, EGender gender, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public List<String> getRoles() {
        return roles;
    }
}
