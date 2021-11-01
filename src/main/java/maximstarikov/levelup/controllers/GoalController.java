package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.GoalFacade;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.GOALS)
@RequiredArgsConstructor
public class GoalController {

    private final GoalFacade goalFacade;

    @PostMapping
    public GoalResponse create(@RequestBody @Valid GoalCreateDto dto) {
        return goalFacade.create(dto);
    }

    @GetMapping("by-uuid/{uuid}")
    public GoalWithStepsResponse getByUuidWithSteps(@PathVariable UUID uuid) {
        return goalFacade.getByUuidWithSteps(uuid);
    }

    public void moveToSuccessJournal() {

    }

    public void completeGoal() {
        
    }

    public void update() {

    }
}
