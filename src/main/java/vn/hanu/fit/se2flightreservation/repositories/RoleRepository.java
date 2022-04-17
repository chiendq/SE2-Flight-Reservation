package vn.hanu.fit.se2flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.se2flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
