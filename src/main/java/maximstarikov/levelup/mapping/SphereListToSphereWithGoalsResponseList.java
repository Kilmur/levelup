package maximstarikov.levelup.mapping;

import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.entities.Sphere;

import java.util.List;

public interface SphereListToSphereWithGoalsResponseList {

    List<SphereWithGoalsResponse> convert(List<Sphere> spheres);
}
