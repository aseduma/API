package za.api.core.service.user;

/**
 * Created by Azael on 2017/08/28.
 */
public interface LoginService {
    String getLoggedInUsername();

    void autoLogin(String username, String password);
}
