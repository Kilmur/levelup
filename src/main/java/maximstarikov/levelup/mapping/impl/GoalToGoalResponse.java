package maximstarikov.levelup.mapping.impl;

import maximstarikov.levelup.models.dto.out.goal.GoalResponse;
import maximstarikov.levelup.models.entities.Goal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class GoalToGoalResponse implements Converter<Goal, GoalResponse> {

    @Override
    public GoalResponse convert(Goal entity) {
        return GoalResponse.create(entity.getUuid(), entity.getName(), entity.getTargetDate(), entity.getDescription(), entity.isFinished(), entity.getBackgroundColor());
    }
}
