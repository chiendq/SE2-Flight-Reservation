package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Role;
import vn.hanu.fit.se2flightreservation.enums.ERole;
import vn.hanu.fit.se2flightreservation.repositories.RoleRepository;
import vn.hanu.fit.se2flightreservation.admin.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
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
}
