package maximstarikov.levelup.mapping;

import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.models.entities.Step;

import java.util.List;

public interface GoalAndStepsToGoalWithStepsResponse {

    GoalWithStepsResponse convert(Goal goal, List<Step> steps);
}
