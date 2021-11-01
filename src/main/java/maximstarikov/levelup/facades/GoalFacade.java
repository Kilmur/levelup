package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;

import java.util.UUID;

public interface GoalFacade {

    GoalResponse create(GoalCreateDto dto);

    GoalWithStepsResponse getByUuidWithSteps(UUID uuid);
}
