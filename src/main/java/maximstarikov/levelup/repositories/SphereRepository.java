package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface SphereRepository extends JpaRepository<Sphere, Long> {

    @EntityGraph(attributePaths = "goals")
    Collection<Sphere> findAllWithGoalsByUserId(Long userId);

    Optional<Sphere> findByUuid(UUID uuid);

    @Modifying
    @Transactional
    @Query("DELETE FROM Sphere s WHERE s.uuid = :uuid")
    void deleteByUuid(UUID uuid);
}
