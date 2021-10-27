package maximstarikov.levelup.models.dto.in.goal;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Value
public class GoalCreateDto {

    @NotNull
    UUID sphereUuid;

    @NotBlank
    String name;

    Instant targetDate;

    String description;

    String backgroundColor;
}
