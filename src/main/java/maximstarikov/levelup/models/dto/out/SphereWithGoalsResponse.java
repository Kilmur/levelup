package maximstarikov.levelup.models.dto.out;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class SphereWithGoalsResponse {

    private String sphereName;

    private Set<Goal> goals;

    public static class Goal {

        private String name;

        private UUID uuid;

        private Instant targetDate;
    }
}
