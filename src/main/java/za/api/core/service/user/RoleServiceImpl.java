package za.api.core.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.api.core.model.user.Role;
import za.api.core.repository.user.RoleRepository;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role getByDescription(String description) {
        return roleRepository.findByDescription(description);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
