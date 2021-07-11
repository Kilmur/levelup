package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.repositories.GoalRepository;
import maximstarikov.levelup.services.GoalService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository repository;

    @Override
    public Goal save(Goal newGoal) {
        return repository.save(newGoal);
    }
}
