package za.api.core.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.api.core.model.user.User;
import za.api.core.service.user.UserService;

import java.util.List;

/**
 * Created by Azael on 2017/12/01.
 */
@RestController
@RequestMapping("/rest/")
@Secured(value = "ADMIN")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user")
    public ResponseEntity<User> getUser(@RequestParam(value = "username", required = false) String username,
                                        @RequestParam(value = "email", required = false) String email) {

        User user = null;

        if(username != null) {
            user = userService.getByUsername(username);
        }else if(email != null){
            user = userService.getByProfileEmail(email);
        }

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAll();
        if(users != null && users.size() > 0){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
