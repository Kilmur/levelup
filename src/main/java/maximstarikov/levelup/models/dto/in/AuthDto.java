package maximstarikov.levelup.models.dto.in;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class AuthDto {

    @NotBlank
    String login;

    @NotBlank
    String password;
}
