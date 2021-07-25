package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.in.SphereUpdateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.sphere.SpheresForStartScreenResponse;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.SPHERES)
@RequiredArgsConstructor
public class SphereController {

    private final SphereFacade sphereFacade;

    @GetMapping("start")
    public SpheresForStartScreenResponse getSpheresForStart() {
        return sphereFacade.getSpheresForStart();
    }

    @PostMapping
    public SphereResponse create(@RequestBody @Valid SphereCreateDto dto) {
        return sphereFacade.create(dto);
    }

    @PutMapping
    public SphereResponse update(@RequestBody @Valid SphereUpdateDto dto) {
        return sphereFacade.update(dto);
    }

    @DeleteMapping("by-uuid/{uuid}")
    public void deleteByUuid(@PathVariable UUID uuid) {
        sphereFacade.deleteByUuid(uuid);
    }
}
