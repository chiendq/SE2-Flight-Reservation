package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.exceptions.EntityExistedByIdException;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.UserRepository;
import vn.hanu.fit.se2flightreservation.admin.services.UserService;

import java.util.List;


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

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
    }

    @Override
    public User updateUser(User userUpdate, int id) {
        if(!userRepository.existsById(id)){
            throw new EntityExistedByIdException("User","id", id);
        }
        User user = userRepository.getById(id);
        userUpdate.setPassword(user.getPassword());
        userUpdate.setId(user.getId());
        return userRepository.save(userUpdate);
    }

    @Override
    public void deleteUserById(int id) {
        if(!userRepository.existsById(id)){
            throw new EntityExistedByIdException("User","id", id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public boolean isEmpty() {
        return userRepository.findAll().size() == 0;
    }
}
