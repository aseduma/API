package za.api.core.service.user;

import za.api.core.model.user.Profile;
import za.api.core.model.user.Role;
import za.api.core.model.user.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
public interface UserService {
    User getByUsername(String username);
    User getByProfile(Profile profile);
    User getByProfileEmail(String email);

    User getByProfileFirstNameAndProfileLastName(String firstName, String lastName);
    User getByProfileFirstNameAndProfileLastNameAllIgnoreCase(String firstName, String lastName);
    User getByProfileIdentityNumber(String identityNumber);
    User getByUsernameAndProfileEmail(String username, String email);

    //UPPER
    User getByUsernameIgnoreCase(String username);
    List<User> getByUsernameLike(String username);
    //Like username%
    List<User> getByUsernameStartingWith(String username);
    //Like %username
    List<User> getByUsernameEndingWith(String username);
    //Like %username%
    List<User> getByUsernameContaining(String username);

    //Date
    List<User> getByCreatedTimestampAfter(Date createdTimestamp);
    List<User> getByCreatedTimestampGreaterThan(Date createdTimestamp);

    List<User> getByCreatedTimestampBefore(Date createdTimestamp);
    List<User> getByCreatedTimestampLessThan(Date createdTimestamp);

    List<User> getByCreatedTimestampGreaterThanEqual(Date createdTimestamp);
    List<User> getByCreatedTimestampLessThanEqual(Date createdTimestamp);
    List<User> getByCreatedTimestamp(Date createdTimestamp);

    List<User> getByCreatedTimestampBetween(Date beforeCreatedTimestamp, Date afterCreatedTimestamp);


    List<User> getAll();
    //<>
    List<User> getByUsernameNot(String username);

    //True/False
    List<User> getByActiveTrue();
    List<User> getByActiveFalse();

    //IN
    List<User> getByRolesIn(Collection<Role> roles);
    List<User> getByRolesNotIn(Collection<Role> roles);

    //Order By
    List<User> getAllOrderByCreatedTimestampDesc();
    List<User> getAllOrderByModifiedTimestamp();
    List<User> getAllOrderByModifiedTimestampDesc();

    //Is Null
    List<User> getByCreatedByIsNull();
    List<User> getByModifiedByIsNull();

    //Is Not Null
    List<User> getByCreatedByIsNotNull();
    List<User> getByModifiedByIsNotNull();

    void save(User user);
    void update(User user);
    void delete(User user);


}
