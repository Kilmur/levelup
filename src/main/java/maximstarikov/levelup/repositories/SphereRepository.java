package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SphereRepository extends JpaRepository<Sphere, Long> {

    List<Sphere> findAllByUserId(Long userId);
}
