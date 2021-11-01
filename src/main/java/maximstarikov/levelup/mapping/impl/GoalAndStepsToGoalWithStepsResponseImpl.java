package maximstarikov.levelup.mapping.impl;

import maximstarikov.levelup.mapping.GoalAndStepsToGoalWithStepsResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.dto.out.goal.GoalWithStepsResponse;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.models.entities.Step;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalAndStepsToGoalWithStepsResponseImpl implements GoalAndStepsToGoalWithStepsResponse {

    @Override
    public GoalWithStepsResponse convert(Goal goal, List<Step> steps) {
        return GoalWithStepsResponse.create(
                GoalResponse.create(goal.getUuid(),
                        goal.getName(),
                        goal.getTargetDate(),
                        goal.getDescription(),
                        goal.isFinished(),
                        goal.getBackgroundColor()),
                steps.stream()
                        .map(entity -> GoalWithStepsResponse.Steps.create(entity.getUuid(), entity.getName(), entity.getBackgroundColor()))
                        .collect(Collectors.toList()));
    }
}
