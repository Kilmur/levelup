package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.UserAlreadyExistsException;
import maximstarikov.levelup.facades.UserFacade;
import maximstarikov.levelup.models.dto.in.RegistrationUserDto;
import maximstarikov.levelup.models.entities.Role;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(RegistrationUserDto dto) {
        if (userService.isExistsByLogin(dto.getLogin())) {
            throw UserAlreadyExistsException.byLogin(dto.getLogin());
        }
        User userForSave = User.builder()
                .login(dto.getLogin())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(Collections.singleton(Role.USER))
                .build();
        userService.save(userForSave);
    }
}
