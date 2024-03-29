package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.in.goal.GoalFinishDto;
import maximstarikov.levelup.models.dto.in.goal.GoalModifyDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;

import java.util.UUID;

public interface GoalFacade {

    GoalResponse create(GoalCreateDto dto);

    GoalWithStepsResponse getByUuidWithSteps(UUID uuid);

    GoalResponse modify(GoalModifyDto dto);

    void changeFinished(GoalFinishDto dto);
}
