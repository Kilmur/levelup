package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.SPHERE)
@RequiredArgsConstructor
public class SphereController {

    private final SphereFacade sphereFacade;

    @GetMapping
    public List<SphereWithGoalsResponse> getSpheresWithGoals() {
        return sphereFacade.getSpheresWithGoals();
    }

    @PostMapping
    public void create() {

    }

    @PutMapping
    public void update() {

    }
}
