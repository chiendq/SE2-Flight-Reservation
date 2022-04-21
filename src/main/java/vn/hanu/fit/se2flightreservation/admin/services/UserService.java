package vn.hanu.fit.se2flightreservation.admin.services;

import vn.hanu.fit.se2flightreservation.entities.User;

public interface UserService {
    boolean isExistsByUsername(String username);

    boolean existsByEmail(String email);

    User save(User user);
}
