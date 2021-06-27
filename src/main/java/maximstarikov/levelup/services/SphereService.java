package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Sphere;

import java.util.Collection;

public interface SphereService {

    Collection<Sphere> getSphereWithGoalsByUserId(Long userId);

    Sphere save(Sphere newSphere);
}
