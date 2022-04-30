package vn.hanu.fit.se2flightreservation.role.user.services;

import vn.hanu.fit.se2flightreservation.entities.User;

public interface UUserService {
    boolean isExistById(int userId);

    User getById(int userId);

}
