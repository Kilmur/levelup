package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.GoalFacade;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.services.GoalService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalFacadeImpl implements GoalFacade {

    private final ConversionService conversionService;
    private final GoalService goalService;

    @Override
    public GoalResponse create(GoalCreateDto dto) {
        Goal savedGoal = goalService.save(conversionService.convert(dto, Goal.class));
        return conversionService.convert(savedGoal, GoalResponse.class);
    }
}
