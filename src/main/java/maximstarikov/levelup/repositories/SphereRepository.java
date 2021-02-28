package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SphereRepository extends JpaRepository<Sphere, Long> {

    @Query("FROM Sphere s JOIN s.goals WHERE s.user.id = :userId")
    List<Sphere> findAllWithGoalsByUserId(Long userId);
}
