package za.api.core.service.user;

import za.api.core.model.user.Profile;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
public interface ProfileService {
    Profile getById(Integer id);
    Profile getByIdentityNumber(String identityNumber);
    Profile getByPassportNumber(String passportNumber);
    Profile getByEmail(String email);
    Profile getByCellNr(String cellNr);
    Profile getByFirstNameAndLastName(String firstName, String lastName);

    List<Profile> getAll();

    void save(Profile profile);
    void update(Profile profile);
    void delete(Profile profile);
}
