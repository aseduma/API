package za.api.core.service.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import za.api.core.model.user.User;
import za.api.core.repository.user.UserRepository;

/**
 * Created by Azael on 2017/12/01.
 */
public class AuditorAwareServiceImpl implements AuditorAware<User> {
    @Autowired
    private UserRepository userRepository;

    public User getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return userRepository.findByUsername(authentication.getName());
    }
}
