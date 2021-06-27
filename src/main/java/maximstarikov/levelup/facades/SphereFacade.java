package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;

import java.util.List;

public interface SphereFacade {

    List<SphereWithGoalsResponse> getSpheresWithGoals();

    SphereResponse create(SphereCreateDto dto);


}
