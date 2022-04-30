package vn.hanu.fit.se2flightreservation.role.admin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.role.admin.dtos.User.SaveUserDto;
import vn.hanu.fit.se2flightreservation.role.admin.converters.UserConverter;
import vn.hanu.fit.se2flightreservation.role.admin.services.UserService;
import vn.hanu.fit.se2flightreservation.entities.User;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @GetMapping("")
//    @JsonFormat
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Credentials", String.valueOf(true))
                .body(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody SaveUserDto saveUserDto) {
        return new ResponseEntity<>(userService.updateUserDto(saveUserDto, id), HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully!.", HttpStatus.OK);
    }
}
