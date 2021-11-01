package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StepRepository extends JpaRepository<Step, Long> {

    List<Step> findAllByGoalId(Long goalId);
}
