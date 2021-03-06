package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.UserFacade;
import maximstarikov.levelup.models.dto.in.RegistrationUserDto;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.REGISTRATION)
@RequiredArgsConstructor
public class RegisterController {

    private final UserFacade userFacade;

    @PostMapping
    public void registration(@RequestBody @Valid RegistrationUserDto dto) {
        userFacade.registrationUser(dto);
    }
}
