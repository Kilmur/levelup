package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.in.SphereUpdateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.sphere.SpheresForStartScreenResponse;

import java.util.UUID;

public interface SphereFacade {

    SpheresForStartScreenResponse getSpheresForStart();

    SphereResponse create(SphereCreateDto dto);

    SphereResponse update(SphereUpdateDto dto);

    void deleteByUuid(UUID uuid);
}
