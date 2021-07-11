package maximstarikov.levelup.models.dto.out.goal;

import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value(staticConstructor = "create")
public class GoalResponse {

    UUID uuid;

    String name;

    Instant targetDate;

    String description;
}
