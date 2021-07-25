package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Role;
import maximstarikov.levelup.models.entities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getByLoginWithRoles(String login);

    Optional<User> getByLogin(String login);

    User save(User userForSave);

    boolean isExistsByLogin(String login);

    User getCurrentUser();

    Role getGeneralRole(User user);
}
