package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.in.SphereUpdateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;

import java.util.List;
import java.util.UUID;

public interface SphereFacade {

    List<SphereWithGoalsResponse> getSpheresWithGoals();

    SphereResponse create(SphereCreateDto dto);

    SphereResponse update(SphereUpdateDto dto);

    void deleteByUuid(UUID uuid);
}
