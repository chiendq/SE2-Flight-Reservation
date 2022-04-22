package vn.hanu.fit.se2flightreservation.user.services.impl;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.UserRepository;
import vn.hanu.fit.se2flightreservation.user.services.UUserService;
@Component
public class UUserServiceImpl implements UUserService {
    private UserRepository userRepository;

    public UUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isExistById(int userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public User getById(int userId) {
        return userRepository.findById(userId).orElseThrow(()->{ throw new ResourceNotFoundException("User","id",userId);
        });
    }
}
