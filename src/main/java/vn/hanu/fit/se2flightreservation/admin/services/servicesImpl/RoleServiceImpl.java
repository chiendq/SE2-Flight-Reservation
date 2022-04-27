package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.enums.ERole;
import vn.hanu.fit.se2flightreservation.exceptions.ResourceNotFoundException;
import vn.hanu.fit.se2flightreservation.repositories.RoleRepository;
import vn.hanu.fit.se2flightreservation.admin.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(ERole roleAdmin) {
        return roleRepository.findByName(roleAdmin).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    @Override
    public Role getById(int id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", id));
    }

    @Override
    public Role updateRole(Role role, int id) {
        Role existingRole = roleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Role","Id",id));
        existingRole.setName(role.getName());
        existingRole.setDescription(role.getDescription());
        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteRoleById(int id) {
        Role existingRole = roleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Role","Id",id));
        roleRepository.delete(existingRole);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public boolean isEmpty() {
        return roleRepository.findAll().size() == 0;
    }
}