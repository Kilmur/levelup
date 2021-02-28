package maximstarikov.levelup.models.dto.out;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SphereWithGoalsResponse {

    String sphereName;

    UUID sphereUUID;

    Set<Goal> goals;

    @Value
    @Builder
    public static class Goal {

        String goalName;

        UUID goalUuid;

        Instant targetDate;
    }
}
