package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    Optional<Goal> findByUuid(UUID uuid);
}
