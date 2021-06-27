package maximstarikov.levelup.models.dto.in;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class SphereCreateDto {

    @NotBlank
    String name;

    String backgroundColor;
}
