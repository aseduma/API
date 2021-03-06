package za.api.core.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.api.core.model.user.Profile;
import za.api.core.model.user.Role;
import za.api.core.model.user.User;
import za.api.core.repository.user.UserRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByProfile(Profile profile) {
        return userRepository.findByProfile(profile);
    }

    @Override
    public User getByProfileEmail(String email) {
        return userRepository.findByProfileEmail(email);
    }

    @Override
    public User getByProfileFirstNameAndProfileLastName(String firstName, String lastName) {
        return userRepository.findByProfileFirstNameAndProfileLastName(firstName, lastName);
    }

    @Override
    public User getByProfileFirstNameAndProfileLastNameAllIgnoreCase(String firstName, String lastName) {
        return userRepository.findByProfileFirstNameAndProfileLastNameAllIgnoreCase(firstName, lastName);
    }

    @Override
    public User getByProfileIdentityNumber(String identityNumber) {
        return userRepository.findByProfileIdentityNumber(identityNumber);
    }

    @Override
    public User getByUsernameAndProfileEmail(String username, String email) {
        return userRepository.findByUsernameAndProfileEmail(username, email);
    }

    @Override
    public User getByUsernameIgnoreCase(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<User> getByUsernameLike(String username) {
        return userRepository.findByUsernameLike(username);
    }

    @Override
    public List<User> getByUsernameStartingWith(String username) {
        return userRepository.findByUsernameStartingWith(username);
    }

    @Override
    public List<User> getByUsernameEndingWith(String username) {
        return userRepository.findByUsernameEndingWith(username);
    }

    @Override
    public List<User> getByUsernameContaining(String username) {
        return userRepository.findByUsernameContaining(username);
    }

    @Override
    public List<User> getByCreatedDateAfter(Date createdDate) {
        return userRepository.findByCreatedDateAfter(createdDate);
    }

    @Override
    public List<User> getByCreatedDateGreaterThan(Date createdDate) {
        return userRepository.findByCreatedDateGreaterThan(createdDate);
    }

    @Override
    public List<User> getByCreatedDateBefore(Date createdDate) {
        return userRepository.findByCreatedDateBefore(createdDate);
    }

    @Override
    public List<User> getByCreatedDateLessThan(Date createdDate) {
        return null;
    }

    @Override
    public List<User> getByCreatedDateGreaterThanEqual(Date createdDate) {
        return userRepository.findByCreatedDateGreaterThanEqual(createdDate);
    }

    @Override
    public List<User> getByCreatedDateLessThanEqual(Date createdDate) {
        return userRepository.findByCreatedDateLessThanEqual(createdDate);
    }

    @Override
    public List<User> getByCreatedDate(Date createdDate) {
        return userRepository.findByCreatedDate(createdDate);
    }

    @Override
    public List<User> getByCreatedDateBetween(Date beforeCreatedDate, Date afterCreatedDate) {
        return userRepository.findByCreatedDateBetween(beforeCreatedDate, afterCreatedDate);
    }

    @Override
    public List<User> getByUsernameNot(String username) {
        return userRepository.findByUsernameNot(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByActiveTrue() {
        return userRepository.findByActiveTrue();
    }

    @Override
    public List<User> getByActiveFalse() {
        return userRepository.findByActiveFalse();
    }

    @Override
    public List<User> getByRolesIn(Collection<Role> roles) {
        return userRepository.findByRolesIn(roles);
    }

    @Override
    public List<User> getByRolesNotIn(Collection<Role> roles) {
        return userRepository.findByRolesNotIn(roles);
    }

    @Override
    public List<User> getAllOrderByCreatedDateDesc() {
        return null;
    }

    @Override
    public List<User> getAllOrderByModifiedDate() {
        return null;
    }

    @Override
    public List<User> getAllOrderByModifiedDateDesc() {
        return null;
    }

    @Override
    public List<User> getByCreatedByIsNull() {
        return userRepository.findByCreatedByIsNull();
    }

    @Override
    public List<User> getByModifiedByIsNull() {
        return userRepository.findByModifiedByIsNull();
    }

    @Override
    public List<User> getByCreatedByIsNotNull() {
        return userRepository.findByCreatedByIsNotNull();
    }

    @Override
    public List<User> getByModifiedByIsNotNull() {
        return userRepository.findByModifiedByIsNotNull();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
