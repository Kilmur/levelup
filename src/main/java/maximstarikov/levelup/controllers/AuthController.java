package maximstarikov.levelup.controllers;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.AuthFacade;
import maximstarikov.levelup.models.dto.in.AuthDto;
import maximstarikov.levelup.models.dto.out.AuthResponse;
import maximstarikov.levelup.properties.Endpoints;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping
    public AuthResponse auth(@RequestBody @Valid AuthDto dto) {
        return authFacade.executeAuth(dto);
    }
}
