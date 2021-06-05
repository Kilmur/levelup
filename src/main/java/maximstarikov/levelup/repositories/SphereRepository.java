package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SphereRepository extends JpaRepository<Sphere, Long> {

    @Query("FROM Sphere s JOIN FETCH s.goals WHERE s.user.id = :userId")
//    @EntityGraph(attributePaths = "goals")
    Collection<Sphere> findAllWithGoalsByUserId(Long userId);
}
