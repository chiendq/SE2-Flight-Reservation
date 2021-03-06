package vn.hanu.fit.se2flightreservation.role.admin.services;

import vn.hanu.fit.se2flightreservation.role.admin.dtos.User.SaveUserDto;
import vn.hanu.fit.se2flightreservation.entities.User;

import java.util.List;

public interface UserService {
    boolean isExistsByUsername(String username);

    boolean existsByEmail(String email);

    User save(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    User updateUser(User userUpdate, int id);

    void deleteUserById(int id);

    void deleteAll();

    boolean isEmpty();

    User updateUserDto(SaveUserDto saveUserDto, int id);
}
