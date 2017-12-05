package za.api.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.api.core.model.user.Role;

/**
 * Created by Azael on 2017/11/30.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    Role findByDescription(String description);
}
