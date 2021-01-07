package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.AuthDto;
import maximstarikov.levelup.models.dto.out.AuthResponse;

public interface AuthFacade {

    AuthResponse executeAuth(AuthDto dto);
}
