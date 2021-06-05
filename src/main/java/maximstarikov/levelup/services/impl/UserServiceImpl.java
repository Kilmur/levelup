package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.repositories.UserRepository;
import maximstarikov.levelup.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<User> getByLoginWithRoles(String login) {
        return repository.getWithRolesByLogin(login);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public User save(User userForSave) {
        return repository.save(userForSave);
    }

    @Override
    public boolean isExistsByLogin(String login) {
        return repository.existsByLogin(login);
    }
}
