package maximstarikov.levelup.models.dto.in.goal;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Value
public class GoalModifyDto {

    @NotNull
    UUID uuid;

    Instant targetDate;

    String name;

    String description;

    Boolean finished;

    String backgroundColor;
}
