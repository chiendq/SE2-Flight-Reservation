package vn.hanu.fit.se2flightreservation.user.services;

import vn.hanu.fit.se2flightreservation.entities.User;

public interface UUserService {
    boolean isExistById(int userId);

    User getById(int userId);

}
