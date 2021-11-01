package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.Step;
import maximstarikov.levelup.repositories.StepRepository;
import maximstarikov.levelup.services.StepService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StepServiceImpl implements StepService {

    private final StepRepository repository;

    @Override
    public List<Step> getAllByGoalId(Long goalId) {
        return repository.findAllByGoalId(goalId);
    }
}
