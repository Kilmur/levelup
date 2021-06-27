package maximstarikov.levelup.models.dto.out;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class SphereResponse {

    UUID uuid;

    String name;

    String backgroundColor;
}
