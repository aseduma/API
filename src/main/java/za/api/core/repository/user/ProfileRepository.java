package za.api.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.api.core.model.user.Profile;

/**
 * Created by Azael on 2017/11/30.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByIdentityNumber(String identityNumber);
    Profile findByPassportNumber(String passportNumber);
    Profile findByEmail(String email);
    Profile findByCellNr(String cellNr);
    Profile findByFirstNameAndLastName(String firstName, String lastName);
}
