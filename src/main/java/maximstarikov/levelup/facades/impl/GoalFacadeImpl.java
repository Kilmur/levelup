package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.GoalNotFoundException;
import maximstarikov.levelup.facades.GoalFacade;
import maximstarikov.levelup.mapping.GoalAndStepsToGoalWithStepsResponse;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.in.goal.GoalModifyDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.models.entities.Step;
import maximstarikov.levelup.services.GoalService;
import maximstarikov.levelup.services.StepService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class GoalFacadeImpl implements GoalFacade {

    private final ConversionService conversionService;
    private final GoalAndStepsToGoalWithStepsResponse goalWithStepsResponseConverter;
    private final GoalService goalService;
    private final StepService stepService;

    @Override
    public GoalResponse create(GoalCreateDto dto) {
        Goal savedGoal = goalService.save(conversionService.convert(dto, Goal.class));
        return conversionService.convert(savedGoal, GoalResponse.class);
    }

    @Override
    public GoalWithStepsResponse getByUuidWithSteps(UUID uuid) {
        Goal goalEntity = goalService.getByUuid(uuid).orElseThrow(() -> GoalNotFoundException.byUuid(uuid));
        List<Step> steps = stepService.getAllByGoalId(goalEntity.getId());
        return goalWithStepsResponseConverter.convert(goalEntity, steps);
    }

    @Override
    @Transactional
    public GoalResponse modify(GoalModifyDto dto) {
        Goal entity = goalService.getByUuid(dto.getUuid()).orElseThrow(() -> GoalNotFoundException.byUuid(dto.getUuid()));
        if (nonNull(dto.getTargetDate())) {
            entity.setTargetDate(dto.getTargetDate());
        }
        if (nonNull(dto.getName())) {
            entity.setName(dto.getName());
        }
        if (nonNull(dto.getDescription())) {
            entity.setDescription(dto.getDescription());
        }
        if (nonNull(dto.getFinished())) {
            entity.setFinished(dto.getFinished());
        }
        if (nonNull(dto.getBackgroundColor())) {
            entity.setBackgroundColor(dto.getBackgroundColor());
        }
        return conversionService.convert(entity, GoalResponse.class);
    }
}
