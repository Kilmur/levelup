package maximstarikov.levelup.models.dto.in;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
public class SphereUpdateDto {

    @NotNull
    UUID uuid;

    String name;

    String backgroundColor;
}
