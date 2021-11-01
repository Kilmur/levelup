package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.Step;

import java.util.List;

public interface StepService {

    List<Step> getAllByGoalId(Long goalId);
}
