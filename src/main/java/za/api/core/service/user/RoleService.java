package za.api.core.service.user;

import za.api.core.model.user.Role;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
public interface RoleService {
    Role getByName(String name);
    Role getByDescription(String description);

    List<Role> getAll();

    void save(Role role);
    void update(Role role);
    void delete(Role role);

}
