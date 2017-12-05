package za.api.core.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.api.core.model.user.Profile;
import za.api.core.repository.user.ProfileRepository;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public Profile getById(Integer id) {
        return profileRepository.findOne(id);
    }

    @Override
    public Profile getByIdentityNumber(String identityNumber) {
        return profileRepository.findByIdentityNumber(identityNumber);
    }

    @Override
    public Profile getByPassportNumber(String passportNumber) {
        return profileRepository.findByPassportNumber(passportNumber);
    }

    @Override
    public Profile getByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public Profile getByCellNr(String cellNr) {
        return profileRepository.findByCellNr(cellNr);
    }

    @Override
    public Profile getByFirstNameAndLastName(String firstName, String lastName) {
        return profileRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void update(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }
}
