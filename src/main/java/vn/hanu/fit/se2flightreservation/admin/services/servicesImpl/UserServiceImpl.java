package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.repositories.UserRepository;
import vn.hanu.fit.se2flightreservation.admin.services.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return userRepository.existsByUsername(username);

    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        String username = user.getUsername();
        if(userRepository.existsByUsername(username)){
            throw new EntityExistedByIdException("User","username", username);
        }
        return userRepository.save(user);
    }
}
