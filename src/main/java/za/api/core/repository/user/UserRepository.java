package za.api.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.api.core.model.user.Profile;
import za.api.core.model.user.Role;
import za.api.core.model.user.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByProfile(Profile profile);
    User findByProfileEmail(String email);

    User findByProfileFirstNameAndProfileLastName(String firstName, String lastName);
    User findByProfileFirstNameAndProfileLastNameAllIgnoreCase(String firstName, String lastName);

    User findByProfileIdentityNumber(String identityNumber);
    User findByUsernameAndProfileEmail(String username, String email);

    //UPPER
    User findByUsernameIgnoreCase(String username);
    List<User> findByUsernameLike(String username);
    //Like username%
    List<User> findByUsernameStartingWith(String username);
    //Like %username
    List<User> findByUsernameEndingWith(String username);
    //Like %username%
    List<User> findByUsernameContaining(String username);

    //Date
    List<User> findByCreatedTimestampAfter(Date createdTimestamp);
    List<User> findByCreatedTimestampGreaterThan(Date createdTimestamp);

    List<User> findByCreatedTimestampBefore(Date createdTimestamp);
    List<User> findByCreatedTimestampLessThan(Date createdTimestamp);

    List<User> findByCreatedTimestampGreaterThanEqual(Date createdTimestamp);
    List<User> findByCreatedTimestampLessThanEqual(Date createdTimestamp);
    List<User> findByCreatedTimestamp(Date createdTimestamp);

    List<User> findByCreatedTimestampBetween(Date beforeCreatedTimestamp, Date afterCreatedTimestamp);


    //<>
    List<User> findByUsernameNot(String username);

    //True/False
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();

    //IN
    List<User> findByRolesIn(Collection<Role> roles);
    List<User> findByRolesNotIn(Collection<Role> roles);

   /* //Order By
    List<User> findAllOrderByCreatedTimestampDesc();
    List<User> findAllOrderByModifiedTimestamp();
    List<User> findAllOrderByModifiedTimestampDesc();*/

    //Is Null
    List<User> findByCreatedByIsNull();
    List<User> findByModifiedByIsNull();

    //Is Not Null
    List<User> findByCreatedByIsNotNull();
    List<User> findByModifiedByIsNotNull();

}
