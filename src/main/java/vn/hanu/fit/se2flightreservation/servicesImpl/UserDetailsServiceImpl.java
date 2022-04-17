package vn.hanu.fit.se2flightreservation.servicesImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.config.UserDetailsImpl;

import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}