package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Sphere;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface SphereService {

    Collection<Sphere> getSphereWithGoalsByUserId(Long userId);

    Sphere save(Sphere newSphere);

    Optional<Sphere> getByUuid(UUID uuid);
}
