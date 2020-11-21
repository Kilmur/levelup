package maximstarikov.levelup.models.dto.in;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class RegistrationUserDto {

    // TODO : разобраться с валидацией
    @NotBlank
    @Size(min = 4, max = 20)
    String login;

    @NotBlank
    @Size(min = 4, max = 20)
    String password;
}
