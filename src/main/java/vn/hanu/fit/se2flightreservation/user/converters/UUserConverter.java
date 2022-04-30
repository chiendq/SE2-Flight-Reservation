package vn.hanu.fit.se2flightreservation.user.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.enums.EGender;
import vn.hanu.fit.se2flightreservation.auth.payload.request.SignupRequest;
import vn.hanu.fit.se2flightreservation.admin.services.RoleService;

import java.util.HashSet;
import java.util.Set;

@Component
public class UUserConverter {
    private final RoleService roleService;

    public UUserConverter(RoleService roleService) {
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
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getById(1));
        signedUpUser.setRoles(roles);

        signedUpUser.setGender(EGender.valueOf(signupRequest.getGender()));

        return signedUpUser;
    }
}
