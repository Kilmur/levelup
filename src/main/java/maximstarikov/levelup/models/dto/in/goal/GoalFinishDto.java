package maximstarikov.levelup.models.dto.in.goal;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
public class GoalFinishDto {

    @NotNull
    UUID uuid;

    @NotNull
    Boolean finished;
}
