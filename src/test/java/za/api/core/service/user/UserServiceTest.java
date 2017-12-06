package za.api.core.service.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import za.api.ApplicationTest;
import za.api.core.model.user.Profile;
import za.api.core.model.user.User;

import java.util.HashSet;

/**
 * Created by Azael on 2017/12/06.
 */
public class UserServiceTest  extends ApplicationTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private RoleService roleService;

    @Test
    @Rollback
    public void saveUserAndRollBack() {
        Profile profile = new Profile();
        profile.setFirstName("Tester");
        profile.setLastName("Tester");
        profile.setCellNr("0000000000");
        profile.setIdentityNumber("0000000000000");
        profile.setEmail("tester@core.com");
        profileService.save(profile);

        User user = new User();
        user.setUsername("tester");
        user.setProfile(profile);
        user.setActive(true);
        user.setHashedPassword(new BCryptPasswordEncoder().encode("core"));
        user.setRoles(new HashSet<>(roleService.getAll()));
        userService.save(user);

    }

    @Test
    public void saveDefaultUser() {
        Profile profile = new Profile();
        profile.setFirstName("Azael");
        profile.setLastName("Seduma");
        profile.setCellNr("0743519649");
        profile.setIdentityNumber("9404145404088");
        profile.setEmail("core@core.com");
        profileService.save(profile);

        User user = new User();
        user.setUsername("core");
        user.setProfile(profile);
        user.setActive(true);
        user.setHashedPassword(new BCryptPasswordEncoder().encode("core"));
        user.setRoles(new HashSet<>(roleService.getAll()));
        userService.save(user);


    }

    @Test
    public void getUser(){
        User user = userService.getByProfileEmail("core@core.com");
        System.out.println(user.toString());

        user = userService.getByUsername("core");
        System.out.println(user.toString());

        user = userService.getByUsername("tester");
        System.out.println(user.toString());

        user = userService.getByProfileFirstNameAndProfileLastName("Azael", "Seduma");
        System.out.println(user.toString());

    }
}
