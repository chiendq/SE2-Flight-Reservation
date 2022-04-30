package vn.hanu.fit.se2flightreservation.role.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.enums.ERole;

import java.util.List;

public interface RoleService {
    Role findByName(ERole roleAdmin);

    Role getById(int id);

    Role save(Role role);

    List<Role> getAllRoles();

    Role getRoleById(int id);

    Role updateRole(Role role, int id);

    void deleteRoleById(int id);

    void deleteAll();

    boolean isEmpty();
}
