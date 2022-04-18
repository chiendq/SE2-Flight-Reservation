package vn.hanu.fit.se2flightreservation.services;

import vn.hanu.fit.se2flightreservation.entities.User;

public interface UserService {
    boolean isExistsByUsername(String username);

    boolean existsByEmail(String email);

    void save(User user);
}