package maximstarikov.levelup.models.dto.in;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class RegistrationUserDto {

    @NotBlank
    @Size(min = 4, max = 30)
    String login;

    @NotBlank
    @Size(min = 4, max = 30)
    String password;
}
