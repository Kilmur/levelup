package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Sphere;

import java.util.List;

public interface SphereService {

    List<Sphere> getSphereWithGoalsByUserId(Long userId);
}
