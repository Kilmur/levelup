package maximstarikov.levelup.controllers;

import maximstarikov.levelup.models.dto.out.UserDto;
import maximstarikov.levelup.properties.Paths;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.USER_ENDPOINT)
public class UserController {

    @GetMapping
    public UserDto getUser() {

    }
}
