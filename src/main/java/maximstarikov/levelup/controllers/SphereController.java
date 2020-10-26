package maximstarikov.levelup.controllers;

import maximstarikov.levelup.models.dto.out.SpheresWithGoalsResponse;
import maximstarikov.levelup.properties.Paths;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.SPHERE_ENDPOINT)
public class SphereController {

    @GetMapping
    public SpheresWithGoalsResponse getSpheresWithGoals() {
        return null;
    }

    @PostMapping
    public void create() {

    }

    @PutMapping
    public void update() {

    }
}
