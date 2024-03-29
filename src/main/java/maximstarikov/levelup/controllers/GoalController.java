package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.GoalFacade;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.in.goal.GoalFinishDto;
import maximstarikov.levelup.models.dto.in.goal.GoalModifyDto;
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

    @GetMapping("{uuid}")
    public GoalWithStepsResponse getByUuidWithSteps(@PathVariable UUID uuid) {
        return goalFacade.getByUuidWithSteps(uuid);
    }

    public void moveToSuccessJournal() {

    }

    @PutMapping
    public GoalResponse modify(@RequestBody @Valid GoalModifyDto dto) {
        return goalFacade.modify(dto);
    }

    @PutMapping("finish")
    public void changeFinished(@RequestBody @Valid GoalFinishDto dto) {
        goalFacade.changeFinished(dto);
    }
}
