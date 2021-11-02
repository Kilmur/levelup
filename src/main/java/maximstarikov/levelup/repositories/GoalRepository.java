package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    Optional<Goal> findByUuid(UUID uuid);

    @Modifying
    @Transactional
    @Query("UPDATE Goal SET finished = :finished WHERE uuid = :uuid")
    void changeFinished(UUID uuid, boolean finished);
}
