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

    @Test
    public void saveAdmin(){
        Role role = new Role();
        role.setName("ADMIN");
        role.setDescription("Administrator");
        roleService.save(role);
    }


    @Test
    public void saveUser(){
        Role role = new Role();
        role.setName("USER");
        role.setDescription("User");
        roleService.save(role);
    }

}
