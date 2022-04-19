package vn.hanu.fit.se2flightreservation.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.models.EGender;
import vn.hanu.fit.se2flightreservation.payload.request.SignupRequest;
import vn.hanu.fit.se2flightreservation.services.RoleService;

import java.util.Set;

@Component
public class UserConverter {
    private final RoleService roleService;

    public UserConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    public User fromSignupRequest(SignupRequest signupRequest) {
        User signedUpUser = new User();
        signedUpUser.setFullname(signupRequest.getFullName());
        signedUpUser.setUsername(signupRequest.getUsername());
        signedUpUser.setPassword(signupRequest.getPassword());
        signedUpUser.setEmail(signupRequest.getEmail());
        signedUpUser.setFullname(signedUpUser.getFullname());
        signedUpUser.setPhone(signupRequest.getPhone());
        signedUpUser.setRoles(Set.of(roleService.getById(1)));

        signedUpUser.setGender(EGender.valueOf(signupRequest.getGender()));

        return signedUpUser;
    }
}
