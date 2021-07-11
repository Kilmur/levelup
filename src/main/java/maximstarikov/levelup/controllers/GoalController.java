package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.GoalFacade;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.GOALS)
@RequiredArgsConstructor
public class GoalController {

    private final GoalFacade goalFacade;

    @PostMapping
    public GoalResponse create(@RequestBody @Valid GoalCreateDto dto) {
        return goalFacade.create(dto);
    }
}
