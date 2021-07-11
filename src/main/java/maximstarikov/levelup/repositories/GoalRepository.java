package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
