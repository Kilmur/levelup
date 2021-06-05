package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "roles")
    Optional<User> getWithRolesByLogin(String login);

    Optional<User> getByLogin(String login);

    boolean existsByLogin(String login);
}
