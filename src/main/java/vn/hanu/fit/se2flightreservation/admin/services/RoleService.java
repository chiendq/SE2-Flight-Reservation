package vn.hanu.fit.se2flightreservation.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.enums.ERole;

public interface RoleService {
    Role findByName(ERole roleAdmin);

    Role getById(int id);
}
