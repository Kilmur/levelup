package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.AuthFacade;
import maximstarikov.levelup.models.dto.in.AuthDto;
import maximstarikov.levelup.models.dto.out.AuthResponse;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.security.JwtProvider;
import maximstarikov.levelup.services.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse executeAuth(AuthDto dto) {
        User user = userService.getByLogin(dto.getLogin()).orElseThrow(() -> new BadCredentialsException("Некорректный логин или пароль"));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Некорректный логин или пароль"); //TODO : поменять на свой exception? Как тут вывести message?
        }
        String token = jwtProvider.generateToken(dto.getLogin());
        return new AuthResponse(token);
    }
}
