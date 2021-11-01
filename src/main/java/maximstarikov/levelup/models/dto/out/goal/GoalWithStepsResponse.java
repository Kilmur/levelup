package maximstarikov.levelup.models.dto.out.goal;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value(staticConstructor = "create")
public class GoalWithStepsResponse {

    GoalResponse goal;

    List<Steps> steps;

    @Value(staticConstructor = "create")
    public static class Steps {
        UUID uuid;
        String name;
        String backgroundColor;
    }
}
