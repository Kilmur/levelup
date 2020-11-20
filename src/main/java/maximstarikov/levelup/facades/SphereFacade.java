package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;

import java.util.List;

public interface SphereFacade {

    List<SphereWithGoalsResponse> getSpheresWithGoals();
}
