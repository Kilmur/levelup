package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;

public interface GoalFacade {

    GoalResponse create(GoalCreateDto dto);
}
