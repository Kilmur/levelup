package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Goal;

import java.util.Optional;
import java.util.UUID;

public interface GoalService {

    Goal save(Goal newGoal);

    Optional<Goal> getByUuid(UUID uuid);

    void changeFinished(UUID uuid, boolean finished);
}
