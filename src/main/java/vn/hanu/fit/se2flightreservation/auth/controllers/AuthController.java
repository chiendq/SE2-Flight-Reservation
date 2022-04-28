package vn.hanu.fit.se2flightreservation.auth.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.jwt.JwtUtils;
import vn.hanu.fit.se2flightreservation.configs.securities.UserDetailsImpl;
import vn.hanu.fit.se2flightreservation.user.converters.UUserConverter;
import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.enums.ERole;
import vn.hanu.fit.se2flightreservation.payload.request.LoginRequest;
import vn.hanu.fit.se2flightreservation.payload.request.SignupRequest;
import vn.hanu.fit.se2flightreservation.payload.response.MessageResponse;
import vn.hanu.fit.se2flightreservation.payload.response.UserInfoResponse;
import vn.hanu.fit.se2flightreservation.admin.services.RoleService;
import vn.hanu.fit.se2flightreservation.admin.services.UserService;

import java.util.*;
import java.util.stream.Collectors;

//@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final RoleService roleService;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    private final UUserConverter userConverter;


    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          RoleService roleService,
                          PasswordEncoder encoder,
                          JwtUtils jwtUtils,
                          UUserConverter userConverter) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.userConverter = userConverter;
    }

    @PostMapping("/signin")
    @JsonFormat
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .header(HttpHeaders.AUTHORIZATION, jwtCookie.getValue())
//                        .header("Access-Control-Allow-Origin", "*")
//                        .header("Access-Control-Allow-Headers", "true")
//                        .header("Access-Control-Allow-Credentials", "true")
//                        .header("Access-Control-Allow-Methods", "*")
//                        .header("Access-Control-Max-Age", "1209600")
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getFullName(),
                        userDetails.getPhoneNumber(),
                        jwtCookie.getValue(),
                        userDetails.getGender(),
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userService.isExistsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode( signUpRequest.getPassword());
        User user = userConverter.fromSignupRequest(signUpRequest);
        user.setPassword(encodedPassword);

        Set<Role> roles = new HashSet<>();

        Role userRole = roleService.findByName(ERole.ROLE_USER);
        roles.add(userRole);
        user.setRoles(roles);
        User registeredUser = userService.save(user);
        System.out.println(registeredUser.toString());
        System.out.println(signUpRequest.toString());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(registeredUser.getUsername(), signUpRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .header(HttpHeaders.AUTHORIZATION, jwtCookie.getValue())
//                        .header("Access-Control-Allow-Origin", "*")
//                        .header("Access-Control-Allow-Headers", "*")
//                        .header("Access-Control-Allow-Credentials", "true")
//                        .header("Access-Control-Allow-Methods", "*")
//                        .header("Access-Control-Max-Age", "1209600")
                .body(new UserInfoResponse(user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getFullname(),
                        user.getPhone(),
                        jwtCookie.getValue(),
                        user.getGender(),
                        Arrays.asList("ROLE_USER")));
    }

    @GetMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Credentials", "true")
                .body(new MessageResponse("You've been signed out!"));
    }

}