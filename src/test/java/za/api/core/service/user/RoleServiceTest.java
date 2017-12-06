package za.api.core.service.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.api.ApplicationTest;
import za.api.core.model.user.Role;

/**
 * Created by Azael on 2017/12/05.
 */
public class RoleServiceTest extends ApplicationTest{
    @Autowired
    private RoleService roleService;

    @Autowired
    private LoginService loginService;

    @Test
    public void saveAdminRole(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        role.setDescription("Administrator");
        roleService.save(role);
    }


    @Test
    public void saveUserRole(){
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setDescription("User");
        roleService.save(role);
    }

}
